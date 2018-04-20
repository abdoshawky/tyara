package com.anwarboss.tyara.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.anwarboss.tyara.utils.ListItem
import com.anwarboss.tyara.R
import com.anwarboss.tyara.adapters.InstructionsAdapter
import com.anwarboss.tyara.models.DataModel
import com.anwarboss.tyara.models.SectionModel
import kotlinx.android.synthetic.main.activity_problems.*
import org.json.JSONArray

class InstructionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problems)

        val bundle = intent.extras

        val title = bundle.getString("titleName")
        val titleID = bundle.getInt("titleID")
        val categoryID = bundle.getInt("categoryID")

        supportActionBar!!.title = title

        val inputStream = assets.open("json/sections.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        val jsonArray = JSONArray(jsonString)

        val inputStream2 = assets.open("json/data.json")

        val size2 = inputStream2.available()

        val buffer2 = ByteArray(size2)
        inputStream2.read(buffer2)
        inputStream2.close()

        val jsonString2 = String(buffer2, charset("UTF-8"))

        val jsonArray2 = JSONArray(jsonString2)

        val itemsList = ArrayList<ListItem>()

        for (i in 0 until jsonArray.length()) {
            val sectionObject = jsonArray.getJSONObject(i)

            val section = SectionModel()

            if (titleID == sectionObject.getInt("title_id")) {
                section.id = sectionObject.getInt("id")
                section.name = sectionObject.getString("name")

                section.titleID = titleID

                itemsList.add(section)

            }

            for (j in 0 until jsonArray2.length()) {
                val dataObject = jsonArray2.getJSONObject(j)

                val data = DataModel()

                val dataSection = dataObject.getInt("section_id")
                val dataTitle = dataObject.getInt("title_id")
                val dataCategory = dataObject.getInt("category_id")

                if (dataSection == section.id && titleID == dataTitle && dataCategory == categoryID) {
                    val dataID = dataObject.getInt("id")
                    val dataKey = dataObject.getString("key")
                    val dataMessage = dataObject.getString("karatMessage")

                    data.id = dataID
                    data.key = dataKey
                    data.karatMessage = dataMessage

                    itemsList.add(data)
                }
            }
        }

        problemsRV.layoutManager = LinearLayoutManager(this@InstructionsActivity)
        problemsRV.adapter = InstructionsAdapter(itemsList)
    }
}
