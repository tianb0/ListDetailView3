package io.tianb.listdetailview3

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

//    init {
//
//        viewModelScope.launch {
//            crimes += loadCrimes()
//        }
//    }

    suspend fun loadCrimes(): List<Crime> {
        Log.d(TAG, "loading crimes")
        val result = mutableListOf<Crime>()
        delay(5000)
        for ( i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0
            )

            result += crime
        }
        Log.d(TAG, "crimes loaded")
        return result
    }
}