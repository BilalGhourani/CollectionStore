package com.bg.collectionsstore.data.Currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class Currency(
    /**
     * Currency Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "cur_id")
    var currencyId: String? = null,

    /**
     * Currency company Id
     * */
    @ColumnInfo(name = "cur_cmp_id")
    var currencyCompId: String,

    /**
     * Currency code 1
     * */
    @ColumnInfo(name = "cur_code1")
    var currencyCode1: String,

    /**
     * Currency name 1
     * */
    @ColumnInfo(name = "cur_name1")
    var currencyName1: String,


    /**
     * Currency Code 2
     * */
    @ColumnInfo(name = "cur_code2")
    var currencyCode2: String,

    /**
     * Currency Name 2
     * */
    @ColumnInfo(name = "cur_name2")
    var currencyName2: String,

    /**
     * Currency Rate
     * */
    @ColumnInfo(name = "cur_rate")
    var currencyRate: Double,

    )
