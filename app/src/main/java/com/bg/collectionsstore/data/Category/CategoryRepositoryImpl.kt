package com.bg.collectionsstore.data.Category

import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }

    override suspend fun delete(category: Category) {
        categoryDao.delete(category)
    }

    override suspend fun update(category: Category) {
        categoryDao.update(category)
    }

    override suspend fun getCategoryById(id: Long): Category {
       return categoryDao.getCategoryById(id)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories()
    }
}