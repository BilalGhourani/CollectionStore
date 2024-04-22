package com.bg.collectionsstore.ui.User

import com.bg.collectionsstore.data.User.User

data class ManageUsersState(
    val users: MutableList<User> = mutableListOf(),
    var selectedUser: User = User(),
    val isLoading: Boolean = false,
    val warning: String? = null,
    )