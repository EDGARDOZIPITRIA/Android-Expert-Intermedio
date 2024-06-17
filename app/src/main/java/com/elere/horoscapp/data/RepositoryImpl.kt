package com.elere.horoscapp.data

import android.util.Log
import com.elere.horoscapp.data.network.HoroscopeApiService
import com.elere.horoscapp.data.network.response.PredictionResponse
import com.elere.horoscapp.domain.model.PredictionModel
import com.elere.horoscapp.domain.model.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sing: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sing) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Ed", "Ha ocurrido un error ${it.message}") }
        return null
    }
}