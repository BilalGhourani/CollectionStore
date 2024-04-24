package com.bg.collectionsstore.data.PosReceipt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import java.util.Date

@Entity(tableName = "pos_receipt")
data class PosReceipt(
    /**
     * POS Receipt Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "pr_id")
    @set:PropertyName("pr_id")
    @get:PropertyName("pr_id")
    var posReceiptId: String,

    @Ignore
    @get:Exclude
    var posReceiptDocumentId: String? = null,

    /**
     * related POS Receipt Invoice Id
     * */
    @ColumnInfo(name = "pr_hi_id")
    @set:PropertyName("pr_hi_id")
    @get:PropertyName("pr_hi_id")
    var posReceiptInvoiceId: String? = null,

    /**
     *  POS Receipt Amount
     * */
    @ColumnInfo(name = "pr_amt")
    @set:PropertyName("pr_amt")
    @get:PropertyName("pr_amt")
    var posReceiptAmount: Double? = null,

    /**
     *  POS Receipt Date
     * */
    @ColumnInfo(name = "pr_timestamp")
    @set:PropertyName("pr_timestamp")
    @get:PropertyName("pr_timestamp")
    var posReceiptTimeStamp: String? = null,


    /**
     *  POS Receipt UserStamp
     * */
    @ColumnInfo(name = "pr_userstamp")
    @set:PropertyName("pr_userstamp")
    @get:PropertyName("pr_userstamp")
    var posReceiptUserStamp: String? = null,
) : DataModel() {
    constructor() : this("")

    @Exclude
    override fun getName(): String {
        return ""
    }

    @Exclude
    fun getMap(): Map<String, Any?> {
        return mapOf(
            "pr_hi_id" to posReceiptInvoiceId,
            "pr_amt" to posReceiptAmount,
            "pr_timestamp" to posReceiptTimeStamp,
            "pr_userstamp" to posReceiptUserStamp
        )
    }
}
