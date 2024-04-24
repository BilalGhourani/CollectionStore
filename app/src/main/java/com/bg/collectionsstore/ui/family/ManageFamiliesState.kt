package com.bg.collectionsstore.ui.family

import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Family.Family

data class ManageFamiliesState(
    val families: MutableList<Family> = mutableListOf(),
    val companies: MutableList<Company> = mutableListOf(),
    var selectedFamily: Family = Family(),
    val isLoading: Boolean = false,
    val warning: String? = null,
    )