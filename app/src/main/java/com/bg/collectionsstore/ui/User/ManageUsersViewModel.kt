package com.bg.collectionsstore.ui.User

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.data.User.UserRepository
import com.bg.collectionsstore.interfaces.OnResult
import com.bg.collectionsstore.model.Resource
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
                override fun onSuccess(result: List<Any>) {
                    val listOfUsers = mutableListOf<User>()
                    result.forEach {
                        listOfUsers.add(it as User)
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

    private fun selectedUser(user: User) {
        manageUsersState.value = manageUsersState.value.copy(
            selectedUser = user
        )
    }

    fun saveUser() {
        manageUsersState.value.selectedUser?.let {
            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(it)
            }
        }
    }

    fun deleteSelectedUser() {
        manageUsersState.value.selectedUser?.let {
            CoroutineScope(Dispatchers.IO).launch {
                repository.delete(it)
            }
        }
    }

}