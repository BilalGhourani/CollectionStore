package com.bg.collectionsstore.data.Invoice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "in_invoice")
data class Invoice(
    /**
     * Room database Invoice ID
     * */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "in_id")
    var invoiceId: String? = null,

    /**
     * related Invoice header id
     * */
    @ColumnInfo(name = "in_hi_id")
    var invoiceHiId: String? = null,

    /**
     * Invoice item id
     * */
    @ColumnInfo(name = "in_it_id")
    var invoiceItemId: String? = null,

    /**
     * Invoice quantity
     * */
    @ColumnInfo(name = "in_qty")
    var invoiceQuantity: Double? = null,

    /**
     * Invoice price
     * */
    @ColumnInfo(name = "in_price")
    var invoicePrice: Double? = null,

    /**
     * Invoice discount
     * */
    @ColumnInfo(name = "in_disc")
    var invoiceDiscount: Double? = null,

    /**
     * Invoice discamt
     * */
    @ColumnInfo(name = "in_discamt")
    var invoiceDiscamt: Double? = null,

    /**
     * Invoice tax
     * */
    @ColumnInfo(name = "in_tax")
    var invoiceTax: Double? = null,

    /**
     * Invoice tax 1
     * */
    @ColumnInfo(name = "in_tax1")
    var invoiceTax1: Double? = null,

    /**
     * Invoice tax 2
     * */
    @ColumnInfo(name = "in_tax2")
    var invoiceTax2: Double? = null,

    /**
     * Invoice note
     * */
    @ColumnInfo(name = "in_note")
    var invoicNote: String? = null,

    /**
     * Invoice cost
     * */
    @ColumnInfo(name = "in_cost")
    var invoicCost: Double? = null,

    /**
     * Invoice remaining quantity
     * */
    @ColumnInfo(name = "in_remqty")
    var invoicRemQty: Double? = null,

    /**
     * Invoice timestamp
     * */
    @ColumnInfo(name = "in_timestamp")
    var invoicTimeStamp: Date? = null,

    /**
     * Invoice userstamp
     * */
    @ColumnInfo(name = "in_userstamp")
    var invoicUserStamp: String? = null,

    /**
     * Invoice extra name
     * */
    @ColumnInfo(name = "in_extraname")
    var invoicExtraName: String? = null,

    )
