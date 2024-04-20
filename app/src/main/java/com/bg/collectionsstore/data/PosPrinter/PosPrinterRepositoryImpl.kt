package com.bg.collectionsstore.data.PosPrinter

import com.bg.collectionsstore.data.Item.Item
import kotlinx.coroutines.flow.Flow

class PosPrinterRepositoryImpl(
    private val posPrinterDao: PosPrinterDao
) : PosPrinterRepository {
    override suspend fun insert(posPrinter: PosPrinter) {
        posPrinterDao.insert(posPrinter)
    }

    override suspend fun delete(posPrinter: PosPrinter) {
        posPrinterDao.delete(posPrinter)
    }

    override suspend fun update(posPrinter: PosPrinter) {
        posPrinterDao.update(posPrinter)
    }

    override suspend fun getPosPrinterById(id: String): PosPrinter {
        return posPrinterDao.getPosPrinterById(id)
    }

    override fun getAllPosPrinters(): Flow<List<PosPrinter>> {
        return posPrinterDao.getAllPosPrinters()
    }

    override fun searchForPosPrinters(key: String): Flow<List<PosPrinter>> {
        return posPrinterDao.searchForPosPrinters(key)
    }


}