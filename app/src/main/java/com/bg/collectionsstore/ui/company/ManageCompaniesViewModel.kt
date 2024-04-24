package com.bg.collectionsstore.ui.company

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Company.CompanyRepository
import com.bg.collectionsstore.interfaces.OnResult
import com.bg.collectionsstore.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageCompaniesViewModel @Inject constructor(
    private val repository: CompanyRepository
) : ViewModel() {

    private val _manageCompaniesState = MutableStateFlow(ManageCompaniesState())
    val manageCompaniesState: MutableStateFlow<ManageCompaniesState> = _manageCompaniesState

    init {
        fetchCompanies()
    }

    private fun fetchCompanies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCompanies(object : OnResult {
                override fun onSuccess(result: Any) {
                    val listOfCompanies = mutableListOf<Company>()
                    (result as List<Company>).forEach {
                        listOfCompanies.add(it)
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        manageCompaniesState.value = manageCompaniesState.value.copy(
                            companies = listOfCompanies
                        )
                    }
                }

                override fun onFailure(message: String) {

                }

            })
        }
    }

    fun saveCompany() {
        val company = manageCompaniesState.value.selectedCompany
        if (company.companyName.isNullOrEmpty() || company.companyAddress.isNullOrEmpty()) {
            manageCompaniesState.value = manageCompaniesState.value.copy(
                warning = "Please fill all inputs",
                isLoading = false
            )
            return
        }
        manageCompaniesState.value = manageCompaniesState.value.copy(
            isLoading = true
        )
        val callback = object : OnResult {
            override fun onSuccess(result: Any) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageCompaniesState.value = manageCompaniesState.value.copy(
                        selectedCompany = result as Company,
                        isLoading = false
                    )
                }
            }

            override fun onFailure(message: String) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageCompaniesState.value = manageCompaniesState.value.copy(
                        isLoading = false
                    )
                }
            }

        }
        manageCompaniesState.value.selectedCompany.let {
            CoroutineScope(Dispatchers.IO).launch {
                if (it.companyDocumentId.isNullOrEmpty()) {
                    it.companyId = Utils.generateRandomUuidString()
                    repository.insert(it, callback)
                } else {
                    repository.update(it, callback)
                }
            }
        }
    }

    fun deleteSelectedCompany() {
        val company = manageCompaniesState.value.selectedCompany
        if (company.companyName.isNullOrEmpty() || company.companyAddress.isNullOrEmpty()) {
            manageCompaniesState.value = manageCompaniesState.value.copy(
                warning = "Please select an company to delete",
                isLoading = false
            )
            return
        }
        manageCompaniesState.value = manageCompaniesState.value.copy(
            warning = null,
            isLoading = true
        )

        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(company, object : OnResult {
                override fun onSuccess(result: Any) {
                    viewModelScope.launch(Dispatchers.Main) {
                        manageCompaniesState.value = manageCompaniesState.value.copy(
                            selectedCompany = result as Company,
                            isLoading = false
                        )
                    }
                }

                override fun onFailure(message: String) {
                    viewModelScope.launch(Dispatchers.Main) {
                        manageCompaniesState.value = manageCompaniesState.value.copy(
                            isLoading = false
                        )
                    }
                }

            })
        }
    }

}