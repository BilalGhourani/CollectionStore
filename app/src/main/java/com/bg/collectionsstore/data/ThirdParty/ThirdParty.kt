package com.bg.collectionsstore.data.ThirdParty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import com.google.firebase.firestore.PropertyName
import java.util.Date

@Entity(tableName = "thirdparty")
data class ThirdParty(
    /**
     * Third Party Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "tp_id")
    @set:PropertyName("tp_id")
    @get:PropertyName("tp_id")
    var thirdPartyId: String,

    /**
     * Third Party name
     * */
    @ColumnInfo(name = "tp_name")
    @set:PropertyName("tp_name")
    @get:PropertyName("tp_name")
    var thirdPartyName: String? = null,

    /**
     * Third Party fn
     * */
    @ColumnInfo(name = "tp_fn")
    @set:PropertyName("tp_fn")
    @get:PropertyName("tp_fn")
    var thirdPartyFn: String? = null,

    /**
     * Third Party company id
     * */
    @ColumnInfo(name = "tp_cmp_id")
    @set:PropertyName("tp_cmp_id")
    @get:PropertyName("tp_cmp_id")
    var thirdPartyCompId: String? = null,


    /**
     * Third Party phone 1
     * */
    @ColumnInfo(name = "tp_phone1")
    @set:PropertyName("tp_phone1")
    @get:PropertyName("tp_phone1")
    var thirdPartyPhone1: String? = null,

    /**
     * Third Party phone 2
     * */
    @ColumnInfo(name = "tp_phone2")
    @set:PropertyName("tp_phone2")
    @get:PropertyName("tp_phone2")
    var thirdPartyPhone2: String? = null,

    /**
     * Third Party address
     * */
    @ColumnInfo(name = "tp_address")
    @set:PropertyName("tp_address")
    @get:PropertyName("tp_address")
    var thirdPartyAddress: String? = null,

    /**
     * Third Party date
     * */
    @ColumnInfo(name = "tp_date")
    @set:PropertyName("tp_date")
    @get:PropertyName("tp_date")
    var thirdPartyDate: String? = null,

    /**
     * Third Party time stamp
     * */
    @ColumnInfo(name = "tp_timestamp")
    @set:PropertyName("tp_timestamp")
    @get:PropertyName("tp_timestamp")
    var thirdPartyTimeStamp: String? = null,

    /**
     * Third Party user stamp
     * */
    @ColumnInfo(name = "tp_userstamp")
    @set:PropertyName("tp_userstamp")
    @get:PropertyName("tp_userstamp")
    var thirdPartyUserStamp: String? = null,

    ) : DataModel() {
    override fun getName(): String {
        return thirdPartyName ?: ""
    }
}
