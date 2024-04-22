package com.bg.collectionsstore.data.User

import com.bg.collectionsstore.interfaces.OnResult
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun insert(user: User, callback: OnResult?) {
        FirebaseFirestore.getInstance().collection("set_users")
            .add(user)
            .addOnSuccessListener {
                CoroutineScope(Dispatchers.IO).launch {
                    userDao.insert(user)
                    callback?.onSuccess(user)
                }
            }
            .addOnFailureListener { e ->
                callback?.onFailure(e.message.toString())
            }
    }

    override suspend fun delete(user: User, callback: OnResult?) {
        FirebaseFirestore.getInstance().collection("set_users")
            .document(user.userDocumentId!!)
            .delete()
            .addOnSuccessListener {
                CoroutineScope(Dispatchers.IO).launch {
                    userDao.delete(user)
                    callback?.onSuccess(user)
                }
            }
            .addOnFailureListener { e ->
                callback?.onFailure(e.message.toString())
            }
    }

    override suspend fun update(user: User, callback: OnResult?) {
        FirebaseFirestore.getInstance().collection("set_users")
            .document(user.userDocumentId!!)
            .update(user.getMap())
            .addOnSuccessListener {
                CoroutineScope(Dispatchers.IO).launch {
                    userDao.update(user)
                    callback?.onSuccess(user)
                }
            }
            .addOnFailureListener { e ->
                callback?.onFailure(e.message.toString())
            }
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
                        val users = mutableListOf<User>()
                        userDao.deleteAll()
                        for (document in result) {
                            val obj = document.toObject(User::class.java)
                            if (!obj.userId.isNullOrEmpty()) {
                                obj.userDocumentId = document.id
                                users.add(obj)
                            }
                        }
                        userDao.insertAll(users.toList())
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