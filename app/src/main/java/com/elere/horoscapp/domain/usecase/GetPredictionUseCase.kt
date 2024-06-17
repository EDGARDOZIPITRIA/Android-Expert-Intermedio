package com.elere.horoscapp.domain.usecase

import com.elere.horoscapp.domain.model.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(sing:String) = repository.getPrediction(sing)

}