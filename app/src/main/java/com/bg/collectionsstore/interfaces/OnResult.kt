package com.bg.collectionsstore.interfaces

interface OnResult {
    fun onSuccess(result: Any)

    fun onFailure(message: String)
}