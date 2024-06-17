package com.elere.horoscapp.ui.home.horocope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elere.horoscapp.R
import com.elere.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter (private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected:(HoroscopeInfo) -> Unit):
    RecyclerView.Adapter<HorocopeViewHolder>(){

        fun updateList(list: List<HoroscopeInfo>){
            horoscopeList = list
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorocopeViewHolder {
        return HorocopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
        
    }

    override fun onBindViewHolder(holder: HorocopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }



    override fun getItemCount() = horoscopeList.size
    }



