package com.bg.collectionsstore.data.Currency

import kotlinx.coroutines.flow.Flow

class CurrencyRepositoryImpl(
    private val currencyDao: CurrencyDao
) : CurrencyRepository {
    override suspend fun insert(currency: Currency) {
        currencyDao.insert(currency)
    }

    override suspend fun delete(currency: Currency) {
        currencyDao.delete(currency)
    }

    override suspend fun update(currency: Currency) {
        currencyDao.update(currency)
    }

    override suspend fun getCurrencyById(id: String): Currency {
        return currencyDao.getCurrencyById(id)
    }

    override fun getAllCurrencies(): Flow<List<Currency>> {
        return currencyDao.getAllCurrencies()
    }

    override fun searchForCurrencies(key: String): Flow<List<Currency>> {
        return currencyDao.searchForCurrencies(key)
    }
}