package com.bg.collectionsstore.ui.Family

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Family.FamilyRepository
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.data.User.UserRepository
import com.bg.collectionsstore.interfaces.OnResult
import com.bg.collectionsstore.model.Resource
import com.bg.collectionsstore.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ManageFamiliesViewModel @Inject constructor(
    private val repository: FamilyRepository
) : ViewModel() {

    private val _manageFamiliesState = MutableStateFlow(ManageFamiliesState())
    val manageFamiliesState: MutableStateFlow<ManageFamiliesState> = _manageFamiliesState

    init {
        fetchFamilies()
    }

    private fun fetchFamilies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllFamilies(object : OnResult {
                override fun onSuccess(result: Any) {
                    val listOfFamilies = mutableListOf<Family>()
                    (result as List<Family>).forEach {
                        listOfFamilies.add(it)
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        manageFamiliesState.value = manageFamiliesState.value.copy(
                            families = listOfFamilies
                        )
                    }
                }

                override fun onFailure(message: String) {

                }

            })
        }
    }

    fun saveFamily() {
        val family = manageFamiliesState.value.selectedFamily
        if (family.familyName.isNullOrEmpty()) {
            manageFamiliesState.value = manageFamiliesState.value.copy(
                warning = "Please fill all inputs",
                isLoading = false
            )
            return
        }
        manageFamiliesState.value = manageFamiliesState.value.copy(
            isLoading = true
        )
        val callback = object : OnResult {
            override fun onSuccess(result: Any) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageFamiliesState.value = manageFamiliesState.value.copy(
                        selectedFamily = result as Family,
                        isLoading = false
                    )
                }
            }

            override fun onFailure(message: String) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageFamiliesState.value = manageFamiliesState.value.copy(
                        isLoading = false
                    )
                }
            }

        }
        manageFamiliesState.value.selectedFamily?.let {
            CoroutineScope(Dispatchers.IO).launch {
                if (it.familyDocumentId.isNullOrEmpty()) {
                    it.familyId = Utils.generateRandomUuidString()
                    repository.insert(it, callback)
                } else {
                    repository.update(it, callback)
                }
            }
        }
    }

    fun deleteSelectedFamily() {
        val family = manageFamiliesState.value.selectedFamily
        if (family.familyName.isNullOrEmpty()) {
            manageFamiliesState.value = manageFamiliesState.value.copy(
                warning = "Please select an user to delete",
                isLoading = false
            )
            return
        }
        manageFamiliesState.value = manageFamiliesState.value.copy(
            warning = null,
            isLoading = true
        )

        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(family, object : OnResult {
                override fun onSuccess(result: Any) {
                    val families = manageFamiliesState.value.families
                    val position =
                        families.indexOfFirst { family.familyId.equals(it.familyId) }
                    if (position >= 0) {
                        families.removeAt(position)
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        manageFamiliesState.value = manageFamiliesState.value.copy(
                            families = families,
                            selectedFamily = Family(),
                            isLoading = false
                        )
                    }
                }

                override fun onFailure(message: String) {
                    viewModelScope.launch(Dispatchers.Main) {
                        manageFamiliesState.value = manageFamiliesState.value.copy(
                            isLoading = false
                        )
                    }
                }

            })
        }
    }

}