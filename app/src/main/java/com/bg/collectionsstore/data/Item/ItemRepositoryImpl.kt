package com.bg.collectionsstore.data.Item

import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(
    private val itemDao: ItemDao
) : ItemRepository {
    override suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

    override suspend fun delete(item: Item) {
        itemDao.delete(item)
    }

    override suspend fun update(item: Item) {
        itemDao.update(item)
    }

    override suspend fun getItemById(id: Long): Item {
        return itemDao.getItemById(id)
    }

    override fun getAllItemes(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }
}