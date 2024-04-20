package com.bg.collectionsstore.data.User

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    // Delete a call log
    @Delete
    suspend fun delete(user: User)

    // Update a call log
    @Update
    suspend fun update(user: User)

    // Get call log by it's ID
    @Query("SELECT * FROM set_users WHERE usr_id = :id")
    suspend fun getUserById(id: String): User

    // Get all call logs as stream.
    @Query("SELECT * FROM `set_users`")
    fun getAllUsers(): Flow<List<User>>

    // Get all call logs as stream.
    @Query("SELECT * FROM `set_users` WHERE usr_name LIKE '%' || :key || '%'")
    fun searchForUsers(key: String): Flow<List<User>>
}