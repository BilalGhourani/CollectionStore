package com.bg.collectionsstore.data.Currency

import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(currency: Currency)

    // Delete a Currency
    suspend fun delete(currency: Currency)

    // Update a Currency
    suspend fun update(currency: Currency)

    // Get Currency by it's ID
    suspend fun getCurrencyById(id: String): Currency

    // Get all Currencies as stream.
    fun getAllCurrencies(): Flow<List<Currency>>

    // Get searched Currencies as stream.
    fun searchForCurrencies(key: String): Flow<List<Currency>>

}
