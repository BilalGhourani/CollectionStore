package com.bg.collectionsstore.data.Item

import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(item: Item)

    // Delete a call log
    suspend fun delete(item: Item)

    // Update a call log
    suspend fun update(item: Item)

    // Get call log by it's ID
    suspend fun getItemById(id: Long): Item

    // Get all call logs as stream.
    fun getAllItemes(): Flow<List<Item>>

}
