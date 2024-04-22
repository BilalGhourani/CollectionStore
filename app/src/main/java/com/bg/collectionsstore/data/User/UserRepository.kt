package com.bg.collectionsstore.data.User

import com.bg.collectionsstore.interfaces.OnResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(user: User, callback: OnResult? = null)

    // Delete an User
    suspend fun delete(user: User, callback: OnResult? = null)

    // Update an User
    suspend fun update(user: User, callback: OnResult? = null)

    // Get User by it's ID
    suspend fun getUserById(id: String): User

    // Get all Users as stream.
    suspend fun getAllUsers(callback: OnResult? = null)
}
