package com.bg.collectionsstore.data.PosPrinter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "pos_printer")
data class PosPrinter(
    /**
     * Room database POS Printer ID
     * */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pp_id")
    var posPrinterId: String? = null,

    /**
     * related  POS Printer type company id
     * */
    @ColumnInfo(name = "pp_cmp_id")
    var posPrinterCompId: String,

    /**
     *   POS Printer name
     * */
    @ColumnInfo(name = "pp_name")
    var posPrinterName: String,

    /**
     *   POS Printer printer
     * */
    @ColumnInfo(name = "pp_printer")
    var posPrinterPrinter: String,


    /**
     *  POS Printer type
     * */
    @ColumnInfo(name = "pp_type")
    var posPrinterType: String,


)
