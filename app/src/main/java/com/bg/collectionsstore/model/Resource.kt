package com.bg.collectionsstore.model

sealed class Resource {

    class Success(val data: MutableList<Any>) : Resource()
    class Failed(val message: String) : Resource()
    class Loading : Resource()
}