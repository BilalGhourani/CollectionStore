package com.bg.collectionsstore.data.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel

@Entity(tableName = "set_users")
data class User(
    /**
     * User Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "usr_id")
    var userId: String,

    /**
     * User name
     * */
    @ColumnInfo(name = "usr_name")
    var userName: String? = null,

    /**
     * User username
     * */
    @ColumnInfo(name = "usr_username")
    var userUsername: String? = null,

    /**
     * User password
     * */
    @ColumnInfo(name = "usr_password")
    var userPassword: String? = null,


    /**
     * related Company Id
     * */
    @ColumnInfo(name = "usr_cmp_id")
    var userCompanyId: String? = null,

    /**
     * related Code
     * */
    @ColumnInfo(name = "usr_code")
    var userCode: String? = null,

    /**
     * related Email
     * */
    @ColumnInfo(name = "usr_email")
    var userEmail: String? = null,

    /**
     * related Expiry
     * */
    @ColumnInfo(name = "usr_expiry")
    var userExpiry: String? = null,

    /**
     * related group description
     * */
    @ColumnInfo(name = "usr_grp_desc")
    var userGrpDesc: String? = null,

    /**
     * related is inactive
     * */
    @ColumnInfo(name = "usr_inactive")
    var userInactive: Int? = 0,

    /**
     * related Start Date
     * */
    @ColumnInfo(name = "usr_startdate")
    var userStartDate: String? = null,

    /**
     * related tp name
     * */
    @ColumnInfo(name = "usr_tp_name")
    var userTpName: String? = null,

    /**
     * related Profile
     * */
    @ColumnInfo(name = "usr_userprofile")
    var userProfile: String? = null,
) : DataModel() {
    constructor() : this("")

    override fun getName(): String {
        return userName ?: ""
    }
}
