package com.bg.collectionsstore.data.Company

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class Company(
    /**
     * Room database autoGenerate ID
     * */
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    /**
     * Company id
     * */
    @ColumnInfo(name = "cmp_id")
    var companyId: String? = null,

    /**
     * Company name
     * */
    @ColumnInfo(name = "cmp_name")
    var companyName: String? = null,

    /**
     * Company Phone
     * */
    @ColumnInfo(name = "cmp_phone")
    var companyPhone: String? = null,

    /**
     * Company Address
     * */
    @ColumnInfo(name = "cmp_address")
    var companyAddress: String? = null,

    /**
     * Company VAT Regno
     * */
    @ColumnInfo(name = "cmp_vatregno")
    var companyVatRegno: String? = null,

    /**
     * Company VAT
     * */
    @ColumnInfo(name = "cmp_vat")
    var companyVat: Double? = null,

    /**
     * Company currency code tax
     * */
    @ColumnInfo(name = "cmp_cur_codetax")
    var companyCurCodeTax: Double? = null,

    /**
     * Company Up With Tax
     * */
    @ColumnInfo(name = "cmp_upwithtax")
    var companyUpWithTax: Double? = null,

    /**
     * Company Email
     * */
    @ColumnInfo(name = "cmp_email")
    var companyEmail: String? = null,

    /**
     * Company Web
     * */
    @ColumnInfo(name = "cmp_web")
    var companyWeb: String? = null,

    /**
     * Company Logo
     * */
    @ColumnInfo(name = "cmp_logo")
    var companyLogo: String? = null,

    /**
     * Company SS
     * */
    @ColumnInfo(name = "cmp_ss")
    var companySS: Boolean = false,

    /**
     * Company Country
     * */
    @ColumnInfo(name = "cmp_country")
    var companyCountry: String? = null,

    /**
     * Company Tax 1
     * */
    @ColumnInfo(name = "cmp_tax1")
    var companyTax1: Double? = null,

    /**
     * Company Tax 1 Regno
     * */
    @ColumnInfo(name = "cmp_tax1regno")
    var companyTax1Regno: String? = null,

    /**
     * Company Tax 2
     * */
    @ColumnInfo(name = "cmp_tax2")
    var companyTax2: Double? = null,

    /**
     * Company Tax 2 Regno
     * */
    @ColumnInfo(name = "cmp_tax2regno")
    var companyTax2Regno: String? = null,

    )
