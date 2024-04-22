package com.bg.collectionsstore.data.Invoice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.PropertyName
import java.util.Date

@Entity(tableName = "in_invoice")
data class Invoice(
    /**
     * Invoice Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "in_id")
    @set:PropertyName("in_id")
    @get:PropertyName("in_id")
    var invoiceId: String,

    /**
     * related Invoice header id
     * */
    @ColumnInfo(name = "in_hi_id")
    @set:PropertyName("in_hi_id")
    @get:PropertyName("in_hi_id")
    var invoiceHiId: String? = null,

    /**
     * Invoice item id
     * */
    @ColumnInfo(name = "in_it_id")
    @set:PropertyName("in_it_id")
    @get:PropertyName("in_it_id")
    var invoiceItemId: String? = null,

    /**
     * Invoice quantity
     * */
    @ColumnInfo(name = "in_qty")
    @set:PropertyName("in_qty")
    @get:PropertyName("in_qty")
    var invoiceQuantity: Double? = null,

    /**
     * Invoice price
     * */
    @ColumnInfo(name = "in_price")
    @set:PropertyName("in_price")
    @get:PropertyName("in_price")
    var invoicePrice: Double? = null,

    /**
     * Invoice discount
     * */
    @ColumnInfo(name = "in_disc")
    @set:PropertyName("in_disc")
    @get:PropertyName("in_disc")
    var invoiceDiscount: Double? = null,

    /**
     * Invoice discamt
     * */
    @ColumnInfo(name = "in_discamt")
    @set:PropertyName("in_discamt")
    @get:PropertyName("in_discamt")
    var invoiceDiscamt: Double? = null,

    /**
     * Invoice tax
     * */
    @ColumnInfo(name = "in_tax")
    @set:PropertyName("in_tax")
    @get:PropertyName("in_tax")
    var invoiceTax: Double? = null,

    /**
     * Invoice tax 1
     * */
    @ColumnInfo(name = "in_tax1")
    @set:PropertyName("in_tax1")
    @get:PropertyName("in_tax1")
    var invoiceTax1: Double? = null,

    /**
     * Invoice tax 2
     * */
    @ColumnInfo(name = "in_tax2")
    @set:PropertyName("in_tax2")
    @get:PropertyName("in_tax2")
    var invoiceTax2: Double? = null,

    /**
     * Invoice note
     * */
    @ColumnInfo(name = "in_note")
    @set:PropertyName("in_note")
    @get:PropertyName("in_note")
    var invoicNote: String? = null,

    /**
     * Invoice cost
     * */
    @ColumnInfo(name = "in_cost")
    @set:PropertyName("in_cost")
    @get:PropertyName("in_cost")
    var invoicCost: Double? = null,

    /**
     * Invoice remaining quantity
     * */
    @ColumnInfo(name = "in_remqty")
    @set:PropertyName("in_remqty")
    @get:PropertyName("in_remqty")
    var invoicRemQty: Double? = null,

    /**
     * Invoice timestamp
     * */
    @ColumnInfo(name = "in_timestamp")
    @set:PropertyName("in_timestamp")
    @get:PropertyName("in_timestamp")
    var invoicTimeStamp: String? = null,

    /**
     * Invoice userstamp
     * */
    @ColumnInfo(name = "in_userstamp")
    @set:PropertyName("in_userstamp")
    @get:PropertyName("in_userstamp")
    var invoicUserStamp: String? = null,

    /**
     * Invoice extra name
     * */
    @ColumnInfo(name = "in_extraname")
    @set:PropertyName("in_extraname")
    @get:PropertyName("in_extraname")
    var invoicExtraName: String? = null,

    )
