package com.bg.collectionsstore.data.PosReceipt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "pos_receipt")
data class PosReceipt(
    /**
     * Room database autoGenerate ID
     * */
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    /**
     * POS Receipt Id
     * */
    @ColumnInfo(name = "pr_id")
    var posReceiptId: String? = null,

    /**
     * related POS Receipt Invoice Id
     * */
    @ColumnInfo(name = "pr_hi_id")
    var posReceiptInvoiceId: String? = null,

    /**
     *  POS Receipt Amount
     * */
    @ColumnInfo(name = "pr_amt")
    var posReceiptAmount: Double? = null,

    /**
     *  POS Receipt Date
     * */
    @ColumnInfo(name = "pr_timestamp")
    var posReceiptTimeStamp: String? = null,


    /**
     *  POS Receipt UserStamp
     * */
    @ColumnInfo(name = "pr_userstamp")
    var posReceiptUserStamp: String? = null,

    )
