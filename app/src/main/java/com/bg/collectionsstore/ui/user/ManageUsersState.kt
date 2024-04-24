package com.bg.collectionsstore.ui.user

import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.User.User

data class ManageUsersState(
    val users: MutableList<User> = mutableListOf(),
    val companies: MutableList<Company> = mutableListOf(),
    var selectedUser: User = User(),
    val isLoading: Boolean = false,
    val warning: String? = null,
    )