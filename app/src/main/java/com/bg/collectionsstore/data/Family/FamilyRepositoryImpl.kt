package com.bg.collectionsstore.data.Family

import kotlinx.coroutines.flow.Flow

class FamilyRepositoryImpl(
    private val familyDao: FamilyDao
) : FamilyRepository {
    override suspend fun insert(family: Family) {
        familyDao.insert(family)
    }

    override suspend fun delete(family: Family) {
        familyDao.delete(family)
    }

    override suspend fun update(family: Family) {
        familyDao.update(family)
    }

    override suspend fun getFamilyById(id: String): Family {
       return familyDao.getFamilyById(id)
    }

    override fun getAllFamilies(): Flow<List<Family>> {
        return familyDao.getAllFamilies()
    }

    override fun searchForFamilies(key: String): Flow<List<Family>> {
        return familyDao.searchForFamilies(key)
    }
}