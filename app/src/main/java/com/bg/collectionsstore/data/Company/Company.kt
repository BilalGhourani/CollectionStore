package com.bg.collectionsstore.data.Company

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "company")
data class Company(
    /**
     * Company id
     * */
    @PrimaryKey
    @ColumnInfo(name = "cmp_id")
    @set:PropertyName("cmp_id")
    @get:PropertyName("cmp_id")
    var companyId: String,

    @Ignore
    @get:Exclude
    var companyDocumentId: String? = null,

    /**
     * Company name
     * */
    @ColumnInfo(name = "cmp_name")
    @set:PropertyName("cmp_name")
    @get:PropertyName("cmp_name")
    var companyName: String? = null,

    /**
     * Company Phone
     * */
    @ColumnInfo(name = "cmp_phone")
    @set:PropertyName("cmp_phone")
    @get:PropertyName("cmp_phone")
    var companyPhone: String? = null,

    /**
     * Company Address
     * */
    @ColumnInfo(name = "cmp_address")
    @set:PropertyName("cmp_address")
    @get:PropertyName("cmp_address")
    var companyAddress: String? = null,

    /**
     * Company VAT Regno
     * */
    @ColumnInfo(name = "cmp_vatregno")
    @set:PropertyName("cmp_vatregno")
    @get:PropertyName("cmp_vatregno")
    var companyVatRegno: String? = null,

    /**
     * Company VAT
     * */
    @ColumnInfo(name = "cmp_vat")
    @set:PropertyName("cmp_vat")
    @get:PropertyName("cmp_vat")
    var companyVat: Double? = null,

    /**
     * Company currency code tax
     * */
    @ColumnInfo(name = "cmp_cur_codetax")
    @set:PropertyName("cmp_cur_codetax")
    @get:PropertyName("cmp_cur_codetax")
    var companyCurCodeTax: Double? = null,

    /**
     * Company Up With Tax
     * */
    @ColumnInfo(name = "cmp_upwithtax")
    @set:PropertyName("cmp_upwithtax")
    @get:PropertyName("cmp_upwithtax")
    var companyUpWithTax: Double? = null,

    /**
     * Company Email
     * */
    @ColumnInfo(name = "cmp_email")
    @set:PropertyName("cmp_email")
    @get:PropertyName("cmp_email")
    var companyEmail: String? = null,

    /**
     * Company Web
     * */
    @ColumnInfo(name = "cmp_web")
    @set:PropertyName("cmp_web")
    @get:PropertyName("cmp_web")
    var companyWeb: String? = null,

    /**
     * Company Logo
     * */
    @ColumnInfo(name = "cmp_logo")
    @set:PropertyName("cmp_logo")
    @get:PropertyName("cmp_logo")
    var companyLogo: String? = null,

    /**
     * Company SS
     * */
    @ColumnInfo(name = "cmp_ss")
    @set:PropertyName("cmp_ss")
    @get:PropertyName("cmp_ss")
    var companySS: Boolean = false,

    /**
     * Company Country
     * */
    @ColumnInfo(name = "cmp_country")
    @set:PropertyName("cmp_country")
    @get:PropertyName("cmp_country")
    var companyCountry: String? = null,

    /**
     * Company Tax 1
     * */
    @ColumnInfo(name = "cmp_tax1")
    @set:PropertyName("cmp_tax1")
    @get:PropertyName("cmp_tax1")
    var companyTax1: Double? = null,

    /**
     * Company Tax 1 Regno
     * */
    @ColumnInfo(name = "cmp_tax1regno")
    @set:PropertyName("cmp_tax1regno")
    @get:PropertyName("cmp_tax1regno")
    var companyTax1Regno: String? = null,

    /**
     * Company Tax 2
     * */
    @ColumnInfo(name = "cmp_tax2")
    @set:PropertyName("cmp_tax2")
    @get:PropertyName("cmp_tax2")
    var companyTax2: Double? = null,

    /**
     * Company Tax 2 Regno
     * */
    @ColumnInfo(name = "cmp_tax2regno")
    @set:PropertyName("cmp_tax2regno")
    @get:PropertyName("cmp_tax2regno")
    var companyTax2Regno: String? = null,

    ) : DataModel() {
    constructor() : this("")

    @Exclude
    override fun getName(): String {
        return companyName ?: ""
    }

    @Exclude
    fun getMap(): Map<String, Any?> {
        return mapOf(
            /*"" to userName,*/
        )
    }
}
