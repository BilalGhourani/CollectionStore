package com.bg.collectionsstore.data.Item

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    // Delete a call log
    @Delete
    suspend fun delete(item: Item)

    // Update a call log
    @Update
    suspend fun update(item: Item)

    // Get call log by it's ID
    @Query("SELECT * FROM Item WHERE itemId = :id")
    suspend fun getItemById(id: Long): Item

    // Get all call logs as stream.
    @Query("SELECT * FROM `Item`")
    fun getAllItems(): Flow<List<Item>>
}