package com.anwarboss.tyara.adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.anwarboss.tyara.utils.ListItem
import com.anwarboss.tyara.R
import com.anwarboss.tyara.models.DataModel
import com.anwarboss.tyara.models.SectionModel

class InstructionsAdapter(private val itemsList: ArrayList<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        println(viewType)

        return when (viewType) {
            ListItem.TYPE_ITEM -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
                DataViewHolder(v)
            }
            else -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                HeaderViewHolder(v)
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val header = itemsList[position] as SectionModel
                holder.headerTV.text = header.name
            }
            is DataViewHolder -> {
                val data = itemsList[position] as DataModel
                holder.keyTV.text = data.key
                holder.messageTV.text = data.karatMessage

                when {
                    data.key == "If" || data.key == "Else if" -> holder.itemView.setBackgroundColor(Color.parseColor("#FFFA00"))
                    data.key == "Note" -> holder.itemView.setBackgroundColor(Color.parseColor("#15D300"))
                    data.key == "WARNING" -> holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"))
                    else -> holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemsList[position].itemType
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val headerTV = itemView.findViewById<TextView>(R.id.key_text)!!

    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val keyTV = itemView.findViewById<TextView>(R.id.key_text)!!
        val messageTV = itemView.findViewById<TextView>(R.id.value_text)!!
    }

}