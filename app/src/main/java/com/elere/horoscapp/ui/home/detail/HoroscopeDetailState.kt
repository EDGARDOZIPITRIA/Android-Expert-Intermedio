package com.elere.horoscapp.ui.home.detail

import com.elere.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val prediction:String,val sign:String, val HoroscopeModel: HoroscopeModel):HoroscopeDetailState()
}