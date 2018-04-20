package com.anwarboss.tyara.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import com.anwarboss.tyara.R
import com.anwarboss.tyara.activities.InstructionsActivity
import com.anwarboss.tyara.models.TitleModel

class TitlesAdapter(private val context: Context, private val problemsListList: List<TitleModel>) : RecyclerView.Adapter<TitlesAdapter.TitlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitlesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_problem, parent, false)
        return TitlesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TitlesViewHolder, position: Int) {
        val problem = problemsListList[position]

        holder.problemTV.text = problem.name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, InstructionsActivity::class.java)
            intent.putExtra("titleName", problem.name)
            intent.putExtra("titleID", problem.id)
            intent.putExtra("categoryID", problem.categoryID)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return problemsListList.size
    }

    inner class TitlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val problemTV = itemView.findViewById<TextView>(R.id.problem_text)!!
    }

}