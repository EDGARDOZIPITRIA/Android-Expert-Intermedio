package com.elere.horoscapp.ui.home.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.elere.horoscapp.R
import com.elere.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.elere.horoscapp.domain.model.HoroscopeModel.Aquarius
import com.elere.horoscapp.domain.model.HoroscopeModel.Aries
import com.elere.horoscapp.domain.model.HoroscopeModel.Cancer
import com.elere.horoscapp.domain.model.HoroscopeModel.Capricorn
import com.elere.horoscapp.domain.model.HoroscopeModel.Gemini
import com.elere.horoscapp.domain.model.HoroscopeModel.Leo
import com.elere.horoscapp.domain.model.HoroscopeModel.Libra
import com.elere.horoscapp.domain.model.HoroscopeModel.Pisces
import com.elere.horoscapp.domain.model.HoroscopeModel.Sagittarius
import com.elere.horoscapp.domain.model.HoroscopeModel.Scorpio
import com.elere.horoscapp.domain.model.HoroscopeModel.Taurus
import com.elere.horoscapp.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_horoscope_detail)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)


    }
    private fun initUI() {
        initListeners()
        initUIState()

    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }

    private fun errorState() {
        binding.progressBar.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when (state.horoscopeModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Libra -> R.drawable.detail_libra
            Virgo -> R.drawable.detail_virgo
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)

    }
}