package com.bg.collectionsstore.data.Category

import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(category: Category)

    // Delete a call log
    suspend fun delete(category: Category)

    // Update a call log
    suspend fun update(category: Category)

    // Get call log by it's ID
    suspend fun getCategoryById(id: Long): Category

    // Get all call logs as stream.
    fun getAllCategories(): Flow<List<Category>>

}
