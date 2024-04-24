package com.bg.collectionsstore.data

import com.google.firebase.firestore.Exclude

abstract class DataModel {
    @Exclude
    open fun getId(): String {
        return ""
    }

    @Exclude
    open fun getName(): String {
        return ""
    }
}