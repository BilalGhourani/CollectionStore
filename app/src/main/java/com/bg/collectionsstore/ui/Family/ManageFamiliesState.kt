package com.bg.collectionsstore.ui.Family

import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.User.User

data class ManageFamiliesState(
    val families: MutableList<Family> = mutableListOf(),
    var selectedFamily: Family = Family(),
    val isLoading: Boolean = false,
    val warning: String? = null,
    )