package com.bg.collectionsstore.data.Company

import kotlinx.coroutines.flow.Flow

class CompanyRepositoryImpl(
    private val companyDao: CompanyDao
) : CompanyRepository {
    override suspend fun insert(company: Company) {
        companyDao.insert(company)
    }

    override suspend fun delete(company: Company) {
        companyDao.delete(company)
    }

    override suspend fun update(company: Company) {
        companyDao.update(company)
    }

    override suspend fun getCompanyById(id: String): Company {
        return companyDao.getCompanyById(id)
    }

    override fun getAllCompanies(): Flow<List<Company>> {
        return companyDao.getAllCompanies()
    }

    override fun searchForCompanies(key: String): Flow<List<Company>> {
        return companyDao.searchForCompanies(key)
    }
}