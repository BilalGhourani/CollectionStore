package com.bg.collectionsstore.data.ThirdParty

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bg.collectionsstore.data.Family.Family
import kotlinx.coroutines.flow.Flow

@Dao
interface ThirdPartyDao {

    // suspend is a coroutine keyword,
    // instead of having a callback we can just wait till insert is done
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(thirdParty: ThirdParty)

    // insert list of Third Parties
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(order: List<ThirdParty>)

    // Delete a Third Party
    @Delete
    suspend fun delete(thirdParty: ThirdParty)

    // Delete all Third Parties
    @Query("DELETE FROM thirdparty")
    suspend fun deleteAll()

    // Update a Third Party
    @Update
    suspend fun update(thirdParty: ThirdParty)

    // Get Third Party by it's ID
    @Query("SELECT * FROM thirdparty WHERE tp_id = :id")
    suspend fun getThirdPartyById(id: String): ThirdParty

    // Get all Third Parties as stream.
    @Query("SELECT * FROM `thirdparty`")
    fun getAllThirdParties(): Flow<List<ThirdParty>>

    // Get searched Third Parties as stream.
    @Query("SELECT * FROM `thirdparty` WHERE tp_name LIKE '%' || :key || '%'")
    fun searchForThirdParties(key: String): Flow<List<ThirdParty>>
}