package com.bg.collectionsstore.data.Currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.PropertyName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "currency")
data class Currency(
    /**
     * Currency Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "cur_id")
    @set:PropertyName("cur_id")
    @get:PropertyName("cur_id")
    var currencyId: String,

    /**
     * Currency company Id
     * */
    @ColumnInfo(name = "cur_cmp_id")
    @set:PropertyName("cur_cmp_id")
    @get:PropertyName("cur_cmp_id")
    var currencyCompId: String,

    /**
     * Currency code 1
     * */
    @ColumnInfo(name = "cur_code1")
    @set:PropertyName("cur_code1")
    @get:PropertyName("cur_code1")
    var currencyCode1: String,

    /**
     * Currency name 1
     * */
    @ColumnInfo(name = "cur_name1")
    @set:PropertyName("cur_name1")
    @get:PropertyName("cur_name1")
    var currencyName1: String,


    /**
     * Currency Code 2
     * */
    @ColumnInfo(name = "cur_code2")
    @set:PropertyName("cur_code2")
    @get:PropertyName("cur_code2")
    var currencyCode2: String,

    /**
     * Currency Name 2
     * */
    @ColumnInfo(name = "cur_name2")
    @set:PropertyName("cur_name2")
    @get:PropertyName("cur_name2")
    var currencyName2: String,

    /**
     * Currency Rate
     * */
    @ColumnInfo(name = "cur_rate")
    @set:PropertyName("cur_rate")
    @get:PropertyName("cur_rate")
    var currencyRate: Double,

    )
