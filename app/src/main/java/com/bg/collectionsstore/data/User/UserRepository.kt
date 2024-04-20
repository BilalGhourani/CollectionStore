package com.bg.collectionsstore.data.User

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(user: User)

    // Delete an User
    suspend fun delete(user: User)

    // Update an User
    suspend fun update(user: User)

    // Get User by it's ID
    suspend fun getUserById(id: String): User

    // Get all Users as stream.
    fun getAllUsers(): Flow<List<User>>

    // Get searched Users as stream.
    fun searchForUsers(key: String): Flow<List<User>>

}
