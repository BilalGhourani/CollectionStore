package com.bg.collectionsstore.data.Category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)

    // Delete a call log
    @Delete
    suspend fun delete(category: Category)

    // Update a call log
    @Update
    suspend fun update(category: Category)

    // Get call log by it's ID
    @Query("SELECT * FROM Category WHERE categoryId = :id")
    suspend fun getCategoryById(id: Long): Category

    // Get all call logs as stream.
    @Query("SELECT * FROM `Category`")
    fun getAllCategories(): Flow<List<Category>>
}