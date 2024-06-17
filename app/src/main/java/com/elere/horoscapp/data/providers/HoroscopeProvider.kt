package com.elere.horoscapp.data.providers

import com.elere.horoscapp.domain.model.HoroscopeInfo
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
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
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
}