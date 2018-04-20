package com.anwarboss.tyara.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.anwarboss.tyara.R
import com.anwarboss.tyara.models.DataModel
import com.anwarboss.tyara.utils.Arrays
import android.media.MediaPlayer


class VoiceAdapter(private val context: Context, private val voicesList: ArrayList<DataModel>) : RecyclerView.Adapter<VoiceAdapter.VoiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoiceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_voice, parent, false)
        return VoiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VoiceViewHolder, position: Int) {
        val data = voicesList[position]


        holder.itemView.setOnClickListener {

        }

        holder.voiceTV.text = data.karatMessage

        val voice = Arrays.voiceArray[position]
        if (voice.isEmpty()) {
            holder.mediaLL.visibility = View.INVISIBLE
        } else {
            val afd = context.assets.openFd("voices/$voice.mp3")
            val player = MediaPlayer()
            player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
            player.prepare()

            holder.playIV.setOnClickListener {
                player.start()
            }

            holder.stopIV.setOnClickListener {
                player.pause()
            }

        }
    }

    override fun getItemCount(): Int {
        return voicesList.size
    }

    inner class VoiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mediaLL = itemView.findViewById<LinearLayout>(R.id.mediaLL)!!
        val playIV = itemView.findViewById<ImageView>(R.id.play)!!
        val stopIV = itemView.findViewById<ImageView>(R.id.stop)!!
        val voiceTV = itemView.findViewById<TextView>(R.id.voiceText)!!
    }

}