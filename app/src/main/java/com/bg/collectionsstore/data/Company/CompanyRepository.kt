package com.bg.collectionsstore.data.Company

import com.bg.collectionsstore.data.Family.Family
import kotlinx.coroutines.flow.Flow

interface CompanyRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(company: Company)

    // Delete a Company
    suspend fun delete(company: Company)

    // Update a Company
    suspend fun update(company: Company)

    // Get Company by it's ID
    suspend fun getCompanyById(id: String): Company

    // Get all Companies logs as stream.
    fun getAllCompanies(): Flow<List<Company>>

    // Get searched Companies logs as stream.
    fun searchForCompanies(key: String): Flow<List<Company>>

}
