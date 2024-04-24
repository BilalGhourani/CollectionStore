package com.bg.collectionsstore.data.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.bg.collectionsstore.data.DataModel
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName

@Entity(tableName = "set_users")
data class User(
    /**
     * User Id
     * */
    @PrimaryKey
    @ColumnInfo(name = "usr_id")
    @set:PropertyName("usr_id")
    @get:PropertyName("usr_id")
    var userId: String,

    @Ignore
    @get:Exclude
    var userDocumentId: String? = null,

    /**
     * User name
     * */
    @ColumnInfo(name = "usr_name")
    @set:PropertyName("usr_name")
    @get:PropertyName("usr_name")
    var userName: String? = null,

    /**
     * User username
     * */
    @ColumnInfo(name = "usr_username")
    @set:PropertyName("usr_username")
    @get:PropertyName("usr_username")
    var userUsername: String? = null,

    /**
     * User password
     * */
    @ColumnInfo(name = "usr_password")
    @set:PropertyName("usr_password")
    @get:PropertyName("usr_password")
    var userPassword: String? = null,


    /**
     * related Company Id
     * */
    @ColumnInfo(name = "usr_cmp_id")
    @set:PropertyName("usr_cmp_id")
    @get:PropertyName("usr_cmp_id")
    var userCompanyId: String? = null,

    /**
     * related Code
     * */
    @ColumnInfo(name = "usr_code")
    @set:PropertyName("usr_code")
    @get:PropertyName("usr_code")
    var userCode: String? = null,

    /**
     * related Email
     * */
    @ColumnInfo(name = "usr_email")
    @set:PropertyName("usr_email")
    @get:PropertyName("usr_email")
    var userEmail: String? = null,

    /**
     * related Expiry
     * */
    @ColumnInfo(name = "usr_expiry")
    @set:PropertyName("usr_expiry")
    @get:PropertyName("usr_expiry")
    var userExpiry: String? = null,

    /**
     * related group description
     * */
    @ColumnInfo(name = "usr_grp_desc")
    @set:PropertyName("usr_grp_desc")
    @get:PropertyName("usr_grp_desc")
    var userGrpDesc: String? = null,

    /**
     * related is inactive
     * */
    @ColumnInfo(name = "usr_inactive")
    @set:PropertyName("usr_inactive")
    @get:PropertyName("usr_inactive")
    var userInactive: String? = null,

    /**
     * related Start Date
     * */
    @ColumnInfo(name = "usr_startdate")
    @set:PropertyName("usr_startdate")
    @get:PropertyName("usr_startdate")
    var userStartDate: String? = null,

    /**
     * related tp name
     * */
    @ColumnInfo(name = "usr_tp_name")
    @set:PropertyName("usr_tp_name")
    @get:PropertyName("usr_tp_name")
    var userTpName: String? = null,

    /**
     * related Profile
     * */
    @ColumnInfo(name = "usr_userprofile")
    @set:PropertyName("usr_userprofile")
    @get:PropertyName("usr_userprofile")
    var userProfile: String? = null,
) : DataModel() {
    constructor() : this("")

    @Exclude
    override fun getName(): String {
        return userName ?: ""
    }

    @Exclude
    fun getMap(): Map<String, Any?> {
        return mapOf(
            /*"usr_name" to userName,*/
            "usr_password" to userPassword,
            "usr_username" to userUsername,
            /*"usr_cmp_id" to userCompanyId,
            "usr_code" to userCode,
            "usr_email" to userEmail,
            "usr_expiry" to userExpiry,
            "usr_grp_desc" to userGrpDesc,
            "usr_inactive" to userInactive,
            "usr_startdate" to userStartDate,
            "usr_tp_name" to userTpName,
            "usr_userprofile" to userProfile,*/
        )
    }
}
