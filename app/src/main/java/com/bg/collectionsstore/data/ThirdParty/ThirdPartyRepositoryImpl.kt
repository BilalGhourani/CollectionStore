package com.bg.collectionsstore.data.ThirdParty

import kotlinx.coroutines.flow.Flow

class ThirdPartyRepositoryImpl(
    private val thirdPartyDao: ThirdPartyDao
) : ThirdPartyRepository {
    override suspend fun insert(thirdParty: ThirdParty) {
        thirdPartyDao.insert(thirdParty)
    }

    override suspend fun delete(thirdParty: ThirdParty) {
        thirdPartyDao.delete(thirdParty)
    }

    override suspend fun update(thirdParty: ThirdParty) {
        thirdPartyDao.update(thirdParty)
    }

    override suspend fun getThirdPartyById(id: String): ThirdParty {
        return thirdPartyDao.getThirdPartyById(id)
    }

    override fun getAllThirdParties(): Flow<List<ThirdParty>> {
        return thirdPartyDao.getAllThirdParties()
    }

    override fun searchForThirdParties(key: String): Flow<List<ThirdParty>> {
        return thirdPartyDao.searchForThirdParties(key)
    }

}