package com.bg.collectionsstore.data.Item

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ITEM")
data class Item(
    /**
     * Room database CallLog ID
     * */
    @PrimaryKey(autoGenerate = true)
    var itemId: Long? = null,

    /**
     * Item name
     * */
    var itemName: String,

    /**
     * Item name
     * */
    var itemCost: String,

    /**
     * Item name
     * */
    var itemCur: String,

)
