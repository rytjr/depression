package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter (var items : Array<DataModel>) : ListAdapter<DataModel,WeatherAdapter.ViewHolder>(diffUtil) {

    // 뷰 홀더 만들어서 반환, 뷰릐 레이아웃은 list_item_weather.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(itemView)
    }

    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    // 아이템 갯수 리턴
    override fun getItemCount() = items.count()

    // 뷰 홀더 설정
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item : DataModel) {
            val tvTime = itemView.findViewById<TextView>(R.id.tvTime)           // 시각
            val tvSky = itemView.findViewById<TextView>(R.id.tvSky)             // 하늘 상태
            val tvTemp = itemView.findViewById<TextView>(R.id.tvTemp)           // 온도

            tvTime.text = item.fcstTime
            tvSky.text = item.sky
            tvTemp.text = item.temp
        }
    }

    companion object{
        val diffUtil = object  : DiffUtil.ItemCallback<DataModel>(){
            override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem.fcstTime == newItem.fcstTime
            }

            override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}

