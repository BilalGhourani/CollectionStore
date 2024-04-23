package com.bg.collectionsstore.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _usersState = MutableStateFlow(LoginState())
    val usersState: MutableStateFlow<LoginState> = _usersState

    fun login(username: String, password: String) {
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            usersState.value = usersState.value.copy(
                warning = "Please fill all inputs",
                isLoading = false
            )
            return
        }
        usersState.value = usersState.value.copy(
            isLoading = true
        )
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUserByCredentials(username, password, object : OnResult {
                override fun onSuccess(result: Any) {
                    if (result is User) {
                        viewModelScope.launch(Dispatchers.Main) {
                            usersState.value = usersState.value.copy(
                                selectedUser = result,
                                isLoading = false,
                                isLoggedIn = true
                            )
                        }
                    }
                }

                override fun onFailure(message: String) {
                    viewModelScope.launch(Dispatchers.Main) {
                        usersState.value = usersState.value.copy(
                            isLoading = false,
                            warning = message
                        )
                    }
                }

            })
        }
    }

}