package com.example.win17.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win17.R
import com.example.win17.model.Losing

class LosingAdapter(val listLosing: List<Losing>):RecyclerView.Adapter<LosingAdapter.LosingHolder>() {

    inner class LosingHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvname = itemView.findViewById<TextView>(R.id.textView_title)
        val tvdesc = itemView.findViewById<TextView>(R.id.textView_desc)
        fun bind(name: String, descriprion: String){
            tvname.text = name
            tvdesc.text = descriprion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LosingHolder {
        return LosingHolder(LayoutInflater.from(parent.context).inflate(R.layout.tips_item, parent, false))
    }

    override fun onBindViewHolder(holder: LosingHolder, position: Int) {
        holder.bind(listLosing[position].title, listLosing[position].description)
    }

    override fun getItemCount(): Int {
        return listLosing.size
    }
}