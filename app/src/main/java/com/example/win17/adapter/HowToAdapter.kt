package com.example.win17.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win17.R
import com.example.win17.model.Howto

class HowToAdapter(val tipsList: ArrayList<Howto>):RecyclerView.Adapter<HowToAdapter.TipsHolder>() {
    inner class TipsHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvname = itemView.findViewById<TextView>(R.id.textView_title)
        val tvdesc = itemView.findViewById<TextView>(R.id.textView_desc)
        fun bind(name: String, descriprion: String){
            tvname.text = name
            tvdesc.text = descriprion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsHolder {
        return TipsHolder(LayoutInflater.from(parent.context).inflate(R.layout.tips_item, parent, false))
    }

    override fun onBindViewHolder(holder: TipsHolder, position: Int) {
        holder.bind(tipsList[position].title, tipsList[position].description)
    }

    override fun getItemCount(): Int {
        return tipsList.size
    }
}