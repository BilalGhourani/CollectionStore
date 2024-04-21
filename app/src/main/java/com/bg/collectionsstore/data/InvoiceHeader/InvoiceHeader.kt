package com.bg.collectionsstore.data.InvoiceHeader

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "in_hinvoice")
data class InvoiceHeader(
    /**
     * Invoice Header Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "hi_id")
    var invoiceHeadId: String? = null,

    /**
     * related Invoice header id
     * */
    @ColumnInfo(name = "hi_cmp_id")
    var invoiceHeadCompId: String? = null,

    /**
     * Invoice Header Date
     * */
    @ColumnInfo(name = "hi_date")
    var invoiceHeadDate: String? = null,

    /**
     * Invoice Header Order Number
     * */
    @ColumnInfo(name = "hi_orderno")
    var invoiceHeadOrderNo: String? = null,

    /**
     * Invoice Header tt code
     * */
    @ColumnInfo(name = "hi_tt_code")
    var invoiceHeadTtCode: String? = null,

    /**
     * Invoice Header Trans number
     * */
    @ColumnInfo(name = "hi_transno")
    var invoiceHeadTransNo: Int? = null,

    /**
     * Invoice Header Status
     * */
    @ColumnInfo(name = "hi_status")
    var invoiceHeadStatus: String? = null,

    /**
     * Invoice Header Note
     * */
    @ColumnInfo(name = "hi_note")
    var invoiceHeadNote: String? = null,

    /**
     * invoice Header Third Party id
     * */
    @ColumnInfo(name = "hi_tp_name")
    var invoiceHeadThirdPartyName: String? = null,

    /**
     * Invoice Header cash name
     * */
    @ColumnInfo(name = "hi_cashname")
    var invoiceHeadCashName: String? = null,

    /**
     * Invoice Header Grossmont
     * */
    @ColumnInfo(name = "hi_grossamt")
    var invoicHeadGrossmont: Double? = null,

    /**
     * Invoice Header Discount
     * */
    @ColumnInfo(name = "hi_disc")
    var invoiceHeadDiscount: Double? = null,

    /**
     * Invoice Header Discamt
     * */
    @ColumnInfo(name = "hi_discamt")
    var invoiceHeadDiscamt: Double? = null,

    /**
     * Invoice header tax amount
     * */
    @ColumnInfo(name = "hi_taxamt")
    var invoicHeadTaxAmt: Double? = null,

    /**
     * Invoice header tax 1 amount
     * */
    @ColumnInfo(name = "hi_tax1amt")
    var invoicHeadTax1Amt: Double? = null,

    /**
     * Invoice header tax 2 amount
     * */
    @ColumnInfo(name = "hi_tax2amt")
    var invoicHeadTax2Amt: Double? = null,

    /**
     * Invoice header total tax
     * */
    @ColumnInfo(name = "hi_totaltax")
    var invoicHeadTotalTax: Double? = null,

    /**
     * Invoice header total
     * */
    @ColumnInfo(name = "hi_total")
    var invoicHeadTotal: Double? = null,

    /**
     * Invoice header total 1
     * */
    @ColumnInfo(name = "hi_total1")
    var invoicHeadTotal1: Double? = null,

    /**
     * Invoice header Rate
     * */
    @ColumnInfo(name = "hi_rates")
    var invoicHeadRate: Double? = null,

    /**
     * Invoice header Ta name
     * */
    @ColumnInfo(name = "hi_ta_name")
    var invoicHeadTaName: String? = null,

    /**
     * Invoice header Clients Count
     * */
    @ColumnInfo(name = "hi_clientscount")
    var invoicHeadClientsCount: Int? = 1,

    /**
     * Invoice header Change
     * */
    @ColumnInfo(name = "hi_change")
    var invoicHeadChange: Double? = null,

    /**
     * Invoice Header timestamp
     * */
    @ColumnInfo(name = "hi_timestamp")
    var invoicHeadTimeStamp: String? = null,

    /**
     * Invoice Header userstamp
     * */
    @ColumnInfo(name = "hi_userstamp")
    var invoicHeadUserStamp: String? = null,


    )
