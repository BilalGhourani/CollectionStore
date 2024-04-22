package com.bg.collectionsstore.ui.User

import com.bg.collectionsstore.data.User.User

data class ManageUsersState(
    val users: MutableList<User> = mutableListOf(),
    val selectedUser: User? = null
)