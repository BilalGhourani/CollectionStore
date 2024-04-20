package com.bg.collectionsstore.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Family.FamilyDao
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.data.Item.ItemDao

@Database(
    entities = [Family::class, Item::class],
    version = 1,
    exportSchema = false
)


abstract class AppDatabase : RoomDatabase() {
    abstract val categoryDao:FamilyDao
    abstract val itemDao: ItemDao
}