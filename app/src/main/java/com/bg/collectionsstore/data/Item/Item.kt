package com.bg.collectionsstore.data.Item

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "st_item")
data class Item(
    /**
     * Room database Item ID
     * */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "it_id")
    var itemId: String? = null,

    /**
     * Item name
     * */
    @ColumnInfo(name = "it_name")
    var itemName: String? = null,

    /**
     * Item barcode
     * */
    @ColumnInfo(name = "it_barcode")
    var itemBarcode: String? = null,

    /**
     * Item unit price
     * */
    @ColumnInfo(name = "it_unitprice")
    var itemUnitPrice: Double? = null,

    /**
     * Item tax
     * */
    @ColumnInfo(name = "it_tax")
    var itemTax: Double? = null,

    /**
     * Item tax 1
     * */
    @ColumnInfo(name = "it_tax1")
    var itemTax1: Double? = null,

    /**
     * Item tax 2
     * */
    @ColumnInfo(name = "it_tax2")
    var itemTax2: Double? = null,

    /**
     * related Item pos printer id
     * */
    @ColumnInfo(name = "it_pp_id")
    var itemPosPrinter: String? = null,

    /**
     * Item open quantity
     * */
    @ColumnInfo(name = "it_openqty")
    var itemOpenQty: Double? = null,

    /**
     * Item open cost
     * */
    @ColumnInfo(name = "it_opencost")
    var itemOpenCost: Double? = null,

    /**
     * related Item POS id
     * */
    @ColumnInfo(name = "it_pos")
    var itemPos: Int? = null,

    /**
     * Item button color
     * */
    @ColumnInfo(name = "it_btncolor")
    var itemBtnColor: Int? = null,

    /**
     * Item button text color
     * */
    @ColumnInfo(name = "it_btntextcolor")
    var itemBtnTextColor: Int? = null,

    /**
     * Item userstamp
     * */
    @ColumnInfo(name = "it_userstamp")
    var itemUserStamp: String? = null,

    /**
     * Item timestamp
     * */
    @ColumnInfo(name = "it_timestamp")
    var itemTimeStamp: Date? = null,












    )
