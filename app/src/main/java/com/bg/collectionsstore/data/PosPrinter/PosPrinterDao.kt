package com.bg.collectionsstore.data.PosPrinter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bg.collectionsstore.data.Item.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface PosPrinterDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(posPrinter: PosPrinter)

    // Delete a POS Printer
    @Delete
    suspend fun delete(posPrinter: PosPrinter)

    // Update a POS Printer
    @Update
    suspend fun update(posPrinter: PosPrinter)

    // Get POS Printer by it's ID
    @Query("SELECT * FROM pos_printer WHERE pp_id = :id")
    suspend fun getPosPrinterById(id: String): PosPrinter

    // Get all POS Printers as stream.
    @Query("SELECT * FROM `pos_printer`")
    fun getAllPosPrinters(): Flow<List<PosPrinter>>

    // Get searched POS Printers as stream.
    @Query("SELECT * FROM `pos_printer` WHERE pp_name LIKE '%' || :key || '%'")
    fun searchForPosPrinters(key: String): Flow<List<PosPrinter>>

}