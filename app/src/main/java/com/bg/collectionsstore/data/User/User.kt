package com.bg.collectionsstore.data.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "set_users")
data class User(
    /**
     * Room database autoGenerate ID
     * */
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    /**
     * User Id
     * */
    @ColumnInfo(name = "usr_id")
    var userId: String? = null,

    /**
     * User name
     * */
    @ColumnInfo(name = "usr_name")
    var userName: String,

    /**
     * User username
     * */
    @ColumnInfo(name = "usr_username")
    var userUsername: String,

    /**
     * User password
     * */
    @ColumnInfo(name = "usr_password")
    var userPassword: String,


    /**
     * related Company Id
     * */
    @ColumnInfo(name = "usr_cmp_id")
    var userCompanyId: String,
    )
