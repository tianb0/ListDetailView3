package io.tianb.listdetailview3.database

import androidx.room.Dao
import androidx.room.Query
import io.tianb.listdetailview3.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): Flow<List<Crime>>
//    suspend fun getCrimes(): List<Crime>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime
}