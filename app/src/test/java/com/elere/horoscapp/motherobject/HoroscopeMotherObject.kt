package com.elere.horoscapp.motherobject

import com.elere.horoscapp.data.network.response.PredictionResponse
import com.elere.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.elere.horoscapp.domain.model.HoroscopeInfo.Aries
import com.elere.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.elere.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.elere.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.elere.horoscapp.domain.model.HoroscopeInfo.Leo
import com.elere.horoscapp.domain.model.HoroscopeInfo.Libra
import com.elere.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.elere.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.elere.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.elere.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.elere.horoscapp.domain.model.HoroscopeInfo.Virgo

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList =  listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces

    )
}