package com.bg.collectionsstore.ui.company

import com.bg.collectionsstore.data.Company.Company

data class ManageCompaniesState(
    val companies: MutableList<Company> = mutableListOf(),
    var selectedCompany: Company = Company(),
    val isLoading: Boolean = false,
    val warning: String? = null,
)