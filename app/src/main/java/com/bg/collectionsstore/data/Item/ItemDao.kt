package com.bg.collectionsstore.data.Item

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bg.collectionsstore.data.Family.Family
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    // Delete an Item
    @Delete
    suspend fun delete(item: Item)

    // Update an Item
    @Update
    suspend fun update(item: Item)

    // Get Item by it's ID
    @Query("SELECT * FROM st_item WHERE it_id = :id")
    suspend fun getItemById(id: String): Item

    // Get all Items as stream.
    @Query("SELECT * FROM `st_item`")
    fun getAllItems(): Flow<List<Item>>

    // Get searched Items as stream.
    @Query("SELECT * FROM `st_item` WHERE it_name LIKE '%' || :key || '%'")
    fun searchForItems(key: String): Flow<List<Item>>
}