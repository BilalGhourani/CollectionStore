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
    var userId: String? = null,

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
) : DataModel() {
    override fun getName(): String {
        return userName ?: ""
    }
}
