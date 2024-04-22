package com.bg.collectionsstore.interfaces

interface OnResult {
    fun onSuccess(result: List<Any>)

    fun onFailure(message: String)
}