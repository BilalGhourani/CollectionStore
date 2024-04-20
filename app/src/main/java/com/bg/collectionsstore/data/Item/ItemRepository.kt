package com.bg.collectionsstore.data.Item

import com.bg.collectionsstore.data.Family.Family
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(item: Item)

    // Delete an Item
    suspend fun delete(item: Item)

    // Update an Item
    suspend fun update(item: Item)

    // Get Item by it's ID
    suspend fun getItemById(id: String): Item

    // Get all Items logs as stream.
    fun getAllItemes(): Flow<List<Item>>

    // Get searched Items logs as stream.
    fun searchForItemes(key: String): Flow<List<Item>>

}
