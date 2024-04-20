package com.bg.collectionsstore.data.Family

import kotlinx.coroutines.flow.Flow

interface FamilyRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(family: Family)

    // Delete a Family
    suspend fun delete(family: Family)

    // Update a Family
    suspend fun update(family: Family)

    // Get Family by it's ID
    suspend fun getFamilyById(id: String): Family

    // Get all Families as stream.
    fun getAllFamilies(): Flow<List<Family>>

    // Get searched Families as stream.
    fun searchForFamilies(key: String): Flow<List<Family>>

}
