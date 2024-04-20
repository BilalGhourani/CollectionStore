package com.bg.collectionsstore.data.PosReceipt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "pos_receipt")
data class PosReceipt(
    /**
     * Room database Family ID
     * */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pr_id")
    var posReceiptId: String? = null,

    /**
     * related POS Receipt Invoice Id
     * */
    @ColumnInfo(name = "pr_hi_id")
    var posReceiptInvoiceId: String,

    /**
     *  POS Receipt Amount
     * */
    @ColumnInfo(name = "pr_amt")
    var posReceiptAmount: Double,

    /**
     *  POS Receipt Date
     * */
    @ColumnInfo(name = "pr_timestamp")
    var posReceiptTimeStamp: Date,


    /**
     *  POS Receipt UserStamp
     * */
    @ColumnInfo(name = "pr_userstamp")
    var posReceiptUserStamp: String,

    )
