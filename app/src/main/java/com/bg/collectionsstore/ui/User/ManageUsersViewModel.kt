package com.bg.collectionsstore.ui.User

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class ManageUsersViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _manageUsersState = MutableStateFlow(ManageUsersState())
    val manageUsersState: MutableStateFlow<ManageUsersState> = _manageUsersState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val listOfUsers = mutableListOf<User>()
            repository.getAllUsers(object : OnResult {
                override fun onSuccess(result: Any) {
                    val listOfUsers = mutableListOf<User>()
                    (result as List<User>).forEach {
                        listOfUsers.add(it)
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        manageUsersState.value = manageUsersState.value.copy(
                            users = listOfUsers
                        )
                    }
                }

                override fun onFailure(message: String) {

                }

            })
        }
    }

    fun saveUser() {
        val user = manageUsersState.value.selectedUser
        if (user.userName.isNullOrEmpty() || user.userPassword.isNullOrEmpty()) {
            manageUsersState.value = manageUsersState.value.copy(
                warning = "Please fill all inputs",
                isLoading = false
            )
            return
        }
        manageUsersState.value = manageUsersState.value.copy(
            isLoading = true
        )
        val callback = object : OnResult {
            override fun onSuccess(result: Any) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageUsersState.value = manageUsersState.value.copy(
                        selectedUser = result as User,
                        isLoading = false
                    )
                }
            }

            override fun onFailure(message: String) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageUsersState.value = manageUsersState.value.copy(
                        isLoading = false
                    )
                }
            }

        }
        manageUsersState.value.selectedUser?.let {
            CoroutineScope(Dispatchers.IO).launch {
                if (it.userDocumentId.isNullOrEmpty()) {
                    it.userId = Utils.generateRandomUuidString()
                    repository.insert(it, callback)
                } else {
                    repository.update(it, callback)
                }
            }
        }
    }

    fun deleteSelectedUser() {
        val user = manageUsersState.value.selectedUser
        if (user.userName.isNullOrEmpty() || user.userPassword.isNullOrEmpty()) {
            manageUsersState.value = manageUsersState.value.copy(
                warning = "Please select an user to delete",
                isLoading = false
            )
            return
        }
        manageUsersState.value = manageUsersState.value.copy(
            warning = null,
            isLoading = true
        )

        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(user, object : OnResult {
                override fun onSuccess(result: Any) {
                    viewModelScope.launch(Dispatchers.Main) {
                        manageUsersState.value = manageUsersState.value.copy(
                            selectedUser = result as User,
                            isLoading = false
                        )
                    }
                }

                override fun onFailure(message: String) {
                    viewModelScope.launch(Dispatchers.Main) {
                        manageUsersState.value = manageUsersState.value.copy(
                            isLoading = false
                        )
                    }
                }

            })
        }
    }

}