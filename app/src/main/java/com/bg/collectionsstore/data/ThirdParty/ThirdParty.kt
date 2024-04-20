package com.bg.collectionsstore.data.ThirdParty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "thirdparty")
data class ThirdParty(
    /**
     * Room database Family ID
     * */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tp_id")
    var thirdPartyId: String? = null,

    /**
     * Third Party name
     * */
    @ColumnInfo(name = "tp_name")
    var thirdPartyName: String,

    /**
     * Third Party fn
     * */
    @ColumnInfo(name = "tp_fn")
    var thirdPartyFn: String,

    /**
     * Third Party company id
     * */
    @ColumnInfo(name = "tp_cmp_id")
    var thirdPartyCompId: String,


    /**
     * Third Party phone 1
     * */
    @ColumnInfo(name = "tp_phone1")
    var thirdPartyPhone1: String,

    /**
     * Third Party phone 2
     * */
    @ColumnInfo(name = "tp_phone2")
    var thirdPartyPhone2: String,

    /**
     * Third Party address
     * */
    @ColumnInfo(name = "tp_address")
    var thirdPartyAddress: String,

    /**
     * Third Party date
     * */
    @ColumnInfo(name = "tp_date")
    var thirdPartyDate: String,

    /**
     * Third Party time stamp
     * */
    @ColumnInfo(name = "tp_timestamp")
    var thirdPartyTimeStamp: Date,

    /**
     * Third Party user stamp
     * */
    @ColumnInfo(name = "tp_userstamp")
    var thirdPartyUserStamp: String,

    )
