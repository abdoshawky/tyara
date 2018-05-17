package com.anwarboss.tyara.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.anwarboss.tyara.R
import com.anwarboss.tyara.activities.TitlesActivity
import com.anwarboss.tyara.models.CategoryModel

class CategoriesAdapter(private val context: Context, private val categoriesList: ArrayList<CategoryModel>, private val normal: Boolean) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_problem, parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categoriesList[position]

        println(normal)

        holder.problemTV.text = category.name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, TitlesActivity::class.java)
            intent.putExtra("id", category.id)
            intent.putExtra("name", category.name)
            intent.putExtra("normal", normal)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val problemTV = itemView.findViewById<TextView>(R.id.problem_text)!!
    }

}