package com.elere.horoscapp.domain.model

import com.elere.horoscapp.data.network.response.PredictionResponse

interface Repository {
    suspend fun getPrediction(sing:String):PredictionModel?
}