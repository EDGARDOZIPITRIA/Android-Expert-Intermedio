package com.elere.horoscapp.ui.home.horocope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.elere.horoscapp.databinding.ItemHoroscopeBinding
import com.elere.horoscapp.domain.model.HoroscopeInfo

class HorocopeViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            starRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
         //   onItemSelected(horoscopeInfo)
        }

    }

    private fun starRotationAnimation(view: View, newLambda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }

    }

}
