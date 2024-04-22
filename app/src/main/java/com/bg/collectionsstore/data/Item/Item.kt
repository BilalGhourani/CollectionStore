package com.bg.collectionsstore.data.Item

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import com.google.firebase.firestore.PropertyName
import java.util.Date

@Entity(tableName = "st_item")
data class Item(
    /**
     * Item Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "it_id")
    @set:PropertyName("it_id")
    @get:PropertyName("it_id")
    var itemId: String,

    /**
     * Item name
     * */
    @ColumnInfo(name = "it_name")
    @set:PropertyName("it_name")
    @get:PropertyName("it_name")
    var itemName: String? = null,

    /**
     * Item barcode
     * */
    @ColumnInfo(name = "it_barcode")
    @set:PropertyName("it_barcode")
    @get:PropertyName("it_barcode")
    var itemBarcode: String? = null,

    /**
     * Item unit price
     * */
    @ColumnInfo(name = "it_unitprice")
    @set:PropertyName("it_unitprice")
    @get:PropertyName("it_unitprice")
    var itemUnitPrice: Double? = null,

    /**
     * Item tax
     * */
    @ColumnInfo(name = "it_tax")
    @set:PropertyName("it_tax")
    @get:PropertyName("it_tax")
    var itemTax: Double? = null,

    /**
     * Item tax 1
     * */
    @ColumnInfo(name = "it_tax1")
    @set:PropertyName("it_tax1")
    @get:PropertyName("it_tax1")
    var itemTax1: Double? = null,

    /**
     * Item tax 2
     * */
    @ColumnInfo(name = "it_tax2")
    @set:PropertyName("it_tax2")
    @get:PropertyName("it_tax2")
    var itemTax2: Double? = null,

    /**
     * related Item pos printer id
     * */
    @ColumnInfo(name = "it_pp_id")
    @set:PropertyName("it_pp_id")
    @get:PropertyName("it_pp_id")
    var itemPosPrinter: String? = null,

    /**
     * Item open quantity
     * */
    @ColumnInfo(name = "it_openqty")
    @set:PropertyName("it_openqty")
    @get:PropertyName("it_openqty")
    var itemOpenQty: Double? = null,

    /**
     * Item open cost
     * */
    @ColumnInfo(name = "it_opencost")
    @set:PropertyName("it_opencost")
    @get:PropertyName("it_opencost")
    var itemOpenCost: Double? = null,

    /**
     * related Item POS id
     * */
    @ColumnInfo(name = "it_pos")
    @set:PropertyName("it_pos")
    @get:PropertyName("it_pos")
    var itemPos: Boolean = false,

    /**
     * Item button color
     * */
    @ColumnInfo(name = "it_btncolor")
    @set:PropertyName("it_btncolor")
    @get:PropertyName("it_btncolor")
    var itemBtnColor: Int? = null,

    /**
     * Item button text color
     * */
    @ColumnInfo(name = "it_btntextcolor")
    @set:PropertyName("it_btntextcolor")
    @get:PropertyName("it_btntextcolor")
    var itemBtnTextColor: Int? = null,

    /**
     * Item userstamp
     * */
    @ColumnInfo(name = "it_userstamp")
    @set:PropertyName("it_userstamp")
    @get:PropertyName("it_userstamp")
    var itemUserStamp: String? = null,

    /**
     * Item timestamp
     * */
    @ColumnInfo(name = "it_timestamp")
    @set:PropertyName("it_timestamp")
    @get:PropertyName("it_timestamp")
    var itemTimeStamp: String? = null,

    ) : DataModel() {
    override fun getName(): String {
        return itemName ?: ""
    }
}
