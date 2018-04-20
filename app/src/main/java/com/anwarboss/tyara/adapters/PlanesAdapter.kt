package com.anwarboss.tyara.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.anwarboss.tyara.models.PlaneModel
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.anwarboss.tyara.R


class PlanesAdapter(private val context: Context, private val planesList: List<PlaneModel>) : BaseAdapter() {


    override fun getCount(): Int {
        return planesList.size
    }

    override fun getItem(position: Int): Any? {
        return planesList[position].name
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val gridView = inflater.inflate(R.layout.item_plane, parent, false)


        val planeTV = gridView.findViewById(R.id.plane_text) as TextView
        planeTV.text = planesList[position].name

        val planeIV = gridView.findViewById(R.id.plane_image) as ImageView
        planeIV.setImageResource(planesList[position].image)

        return gridView
    }
}
