package com.bg.collectionsstore.data.Family

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import org.jetbrains.annotations.NotNull

@Entity(tableName = "st_family")
data class Family(
    /**
     * Family Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "fa_id")
    var familyId: String,

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

    ) : DataModel() {
    override fun getName(): String {
        return familyName ?: ""
    }
}
