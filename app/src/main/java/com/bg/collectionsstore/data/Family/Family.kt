package com.bg.collectionsstore.data.Family

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "st_family")
data class Family(
    /**
     * Room database autoGenerate ID
     * */
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    /**
     * Family Id
     * */
    @ColumnInfo(name = "fa_id")
    var familyId: String? = null,

    /**
     * Family name
     * */
    @ColumnInfo(name = "fa_name")
    var familyName: String? = null,


    /**
     * related Company Id
     * */
    @ColumnInfo(name = "fa_cmp_id")
    var familyCompanyId: String? = null,

    )
