package com.bg.collectionsstore.ui.User

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.data.User.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ManageUsersViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val state = mutableStateOf(ManageUsersState())

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val listOfUsers = mutableListOf<User>()
            repository.getAllUsers().onEach {
                listOfUsers.addAll(it)
            }
            withContext(Dispatchers.Main) {
                state.value = state.value.copy(
                    users = listOfUsers
                )
            }
        }
    }

    private fun selectedUser(user: User) {
        state.value = state.value.copy(
            selectedUser = user
        )
    }

    fun saveUser() {
        state.value.selectedUser?.let {
            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(it)
            }
        }
    }

    fun deleteSelectedUser() {
        state.value.selectedUser?.let {
            CoroutineScope(Dispatchers.IO).launch {
                repository.delete(it)
            }
        }
    }

}