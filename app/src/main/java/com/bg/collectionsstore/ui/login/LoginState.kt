package com.bg.collectionsstore.ui.login

import com.bg.collectionsstore.data.User.User

data class LoginState(
    var selectedUser: User = User(),
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val warning: String? = null,
)