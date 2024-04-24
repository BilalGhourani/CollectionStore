package com.bg.collectionsstore.data

abstract class DataModel {
    open fun getId(): String {
        return ""
    }

    open fun getName(): String {
        return ""
    }
}