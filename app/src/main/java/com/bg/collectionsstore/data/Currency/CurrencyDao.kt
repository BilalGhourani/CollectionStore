package com.bg.collectionsstore.data.Currency

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: Currency)

    // Delete a Currency
    @Delete
    suspend fun delete(currency: Currency)

    // Update a Currency
    @Update
    suspend fun update(currency: Currency)

    // Get Currency by it's ID
    @Query("SELECT * FROM `currency` WHERE cur_id = :id")
    suspend fun getCurrencyById(id: String): Currency

    // Get all Currencies as stream.
    @Query("SELECT * FROM `currency`")
    fun getAllCurrencies(): Flow<List<Currency>>

    // get searched Currencies as stream.
    @Query("SELECT * FROM `currency` WHERE cur_name1 LIKE '%' || :key || '%' OR cur_name2 LIKE '%' || :key || '%'")
    fun searchForCurrencies(key: String): Flow<List<Currency>>
}