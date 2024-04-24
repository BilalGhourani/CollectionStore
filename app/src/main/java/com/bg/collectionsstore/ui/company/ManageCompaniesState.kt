package com.bg.collectionsstore.ui.company

import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Currency.Currency

data class ManageCompaniesState(
    val companies: MutableList<Company> = mutableListOf(),
    val currencies: MutableList<Currency> = mutableListOf(),
    var selectedCompany: Company = Company(),
    val isLoading: Boolean = false,
    val warning: String? = null,
)