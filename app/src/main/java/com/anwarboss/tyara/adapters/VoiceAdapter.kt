package com.anwarboss.tyara.adapters

import android.content.Context
import android.content.Intent
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
import com.anwarboss.tyara.activities.InstructionsActivity


class VoiceAdapter(private val context: Context, private val voicesList: ArrayList<DataModel>) : RecyclerView.Adapter<VoiceAdapter.VoiceViewHolder>() {

    private val player = MediaPlayer()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoiceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_voice, parent, false)
        return VoiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VoiceViewHolder, position: Int) {
        val data = voicesList[position]

        holder.setIsRecyclable(false)

        holder.voiceTV.text = data.karatMessage

        val voice = Arrays.voiceArray[position]


        if (voice.isEmpty()) {
            holder.mediaLL.visibility = View.INVISIBLE
            holder.itemView.setOnClickListener {
                val intent = Intent(context, InstructionsActivity::class.java)
                intent.putExtra("titleName", data.titleName)
                intent.putExtra("titleID", data.titleID)
                intent.putExtra("categoryID", data.categoryID)
                context.startActivity(intent)
            }
        } else {
            holder.mediaLL.visibility = View.VISIBLE

            holder.itemView.setOnClickListener {

                val intent = Intent(context, InstructionsActivity::class.java)
                intent.putExtra("titleName", data.titleName)
                intent.putExtra("titleID", data.titleID)
                intent.putExtra("categoryID", data.categoryID)
                context.startActivity(intent)
                val afd = if(voice == "refueling_pod_failure_switch_on_disconnection_lights"){
                    context.assets.openFd("voices/$voice.mp3")
                }else{
                    context.assets.openFd("voices/$voice.wav")
                }
                player.reset()
                player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                player.prepare()
                player.start()
            }

            holder.playIV.setOnClickListener {
                val afd = if(voice == "refueling_pod_failure_switch_on_disconnection_lights"){
                    context.assets.openFd("voices/$voice.mp3")
                }else{
                    context.assets.openFd("voices/$voice.wav")
                }

                player.reset()
                player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                player.prepare()
                player.start()
            }

            holder.stopIV.setOnClickListener {
                if (player.isPlaying) {
                    player.stop()
                }
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