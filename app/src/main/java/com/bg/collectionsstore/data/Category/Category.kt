package com.bg.collectionsstore.data.Category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CATEGORY")
data class Category(
    /**
     * Room database CallLog ID
     * */
    @PrimaryKey(autoGenerate = true)
    var categoryId: Long? = null,

    /**
     * Category name
     * */
    var categoryName: String,

)
