package com.bg.collectionsstore.data.PosPrinter

import com.bg.collectionsstore.data.Item.Item
import kotlinx.coroutines.flow.Flow

interface PosPrinterRepository {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    suspend fun insert(posPrinter: PosPrinter)

    // Delete a POS Printer
    suspend fun delete(posPrinter: PosPrinter)

    // Update a POS Printer
    suspend fun update(posPrinter: PosPrinter)

    // Get POS Receipt by it's ID
    suspend fun getPosPrinterById(id: String): PosPrinter

    // Get all POS Receipts as stream.
    fun getAllPosPrinters(): Flow<List<PosPrinter>>

    // Get searched Items logs as stream.
    fun searchForPosPrinters(key: String): Flow<List<PosPrinter>>

}
