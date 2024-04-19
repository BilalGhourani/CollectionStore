package com.bg.collectionsstore.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bg.collectionsstore.data.Category.Category
import com.bg.collectionsstore.data.Category.CategoryDao
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.data.Item.ItemDao

@Database(
    entities = [Category::class, Item::class],
    version = 1,
    exportSchema = false
)


abstract class AppDatabase : RoomDatabase() {
    abstract val categoryDao:CategoryDao
    abstract val itemDao: ItemDao
}