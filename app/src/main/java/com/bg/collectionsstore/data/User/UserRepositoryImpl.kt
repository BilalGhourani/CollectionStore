package com.bg.collectionsstore.data.User

import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun insert(user: User) {
        userDao.insert(user)
    }

    override suspend fun delete(user: User) {
        userDao.delete(user)
    }

    override suspend fun update(user: User) {
        userDao.update(user)
    }

    override suspend fun getUserById(id: String): User {
        return userDao.getUserById(id)
    }

    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override fun searchForUsers(key: String): Flow<List<User>> {
        return userDao.searchForUsers(key)
    }
}