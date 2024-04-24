package com.bg.collectionsstore.ui.currency

import com.bg.collectionsstore.data.Currency.Currency

data class ManageCurrenciesState(
    val currencies: MutableList<Currency> = mutableListOf(),
    var selectedCurrency: Currency = Currency(),
    val isLoading: Boolean = false,
    val warning: String? = null,
    )