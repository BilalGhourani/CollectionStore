package com.bg.collectionsstore.data.PosPrinter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import com.google.firebase.firestore.PropertyName
import java.util.Date

@Entity(tableName = "pos_printer")
data class PosPrinter(
    /**
     * POS Printer Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "pp_id")
    @set:PropertyName("pp_id")
    @get:PropertyName("pp_id")
    var posPrinterId: String,

    /**
     * related  POS Printer type company id
     * */
    @ColumnInfo(name = "pp_cmp_id")
    @set:PropertyName("pp_cmp_id")
    @get:PropertyName("pp_cmp_id")
    var posPrinterCompId: String,

    /**
     *   POS Printer name
     * */
    @ColumnInfo(name = "pp_name")
    @set:PropertyName("pp_name")
    @get:PropertyName("pp_name")
    var posPrinterName: String,

    /**
     *   POS Printer printer
     * */
    @ColumnInfo(name = "pp_printer")
    @set:PropertyName("pp_printer")
    @get:PropertyName("pp_printer")
    var posPrinterPrinter: String,


    /**
     *  POS Printer type
     * */
    @ColumnInfo(name = "pp_type")
    @set:PropertyName("pp_type")
    @get:PropertyName("pp_type")
    var posPrinterType: String,


    ) : DataModel() {
    override fun getName(): String {
        return posPrinterName ?: ""
    }
}
