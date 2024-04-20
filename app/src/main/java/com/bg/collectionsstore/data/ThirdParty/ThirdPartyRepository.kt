package com.bg.collectionsstore.data.ThirdParty

import kotlinx.coroutines.flow.Flow

interface ThirdPartyRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(thirdParty: ThirdParty)

    // Delete a ThirdParty
    suspend fun delete(thirdParty: ThirdParty)

    // Update a ThirdParty
    suspend fun update(thirdParty: ThirdParty)

    // Get ThirdParty by it's ID
    suspend fun getThirdPartyById(id: String): ThirdParty

    // Get all ThirdParties as stream.
    fun getAllThirdParties(): Flow<List<ThirdParty>>

    // Get searched ThirdParties as stream.
    fun searchForThirdParties(key: String): Flow<List<ThirdParty>>

}
