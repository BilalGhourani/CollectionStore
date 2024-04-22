package com.bg.collectionsstore.data.User

import com.bg.collectionsstore.App
import com.bg.collectionsstore.interfaces.OnResult
import com.bg.collectionsstore.model.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

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

    override suspend fun getAllUsers(callback: OnResult?) {
        userDao.getAllUsers().collect {
            callback?.onSuccess(it)
            FirebaseFirestore.getInstance().collection("set_users").get()
                .addOnSuccessListener { result ->
                    CoroutineScope(Dispatchers.IO).launch {
                        val users = mutableListOf<Any>()
                        for (document in result) {
                            val obj = document.toObject(User::class.java)
                            if (!obj.userId.isNullOrEmpty()) {
                                userDao.insert(obj)
                                users.add(obj)
                            }
                        }
                        callback?.onSuccess(users)
                    }
                }.addOnFailureListener { exception ->
                    callback?.onFailure(
                        exception.message ?: "Network error! Can't get users from remote."
                    )
                }
        }
    }
}