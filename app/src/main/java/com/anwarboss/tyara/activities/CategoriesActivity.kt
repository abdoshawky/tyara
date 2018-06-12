package com.anwarboss.tyara.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.anwarboss.tyara.R
import com.anwarboss.tyara.adapters.CategoriesAdapter
import com.anwarboss.tyara.adapters.VoiceAdapter
import com.anwarboss.tyara.models.CategoryModel
import com.anwarboss.tyara.models.DataModel
import kotlinx.android.synthetic.main.activity_problems.*
import org.json.JSONArray
import java.io.InputStream


class CategoriesActivity : AppCompatActivity() {

    private var normal = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problems)

        val category = intent.extras.getString("category")

        supportActionBar!!.title = category

        val inputStream: InputStream

        problemsRV.layoutManager = LinearLayoutManager(this@CategoriesActivity)

        normal = category == "Normal"

        inputStream = when (category) {
            "Abnormal" -> assets.open("json/up normal/categoriesUpnormal.json")
            "Normal" -> assets.open("json/normal/categories.json")
            "Voice Warning" -> assets.open("json/up normal/data.json")
            else -> assets.open("json/up normal/data.json")
        }

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))
        val jsonArray = JSONArray(jsonString)


        if (category == "Voice Warning") {
            getVoices(jsonArray)
        } else {
            getProblems(jsonArray)
        }


    }

    private fun getVoices(jsonArray: JSONArray) {

        val problems = ArrayList<DataModel>()

        for (i in 0 until jsonArray.length()) {
            val categoryObject = jsonArray.getJSONObject(i)
            val key = categoryObject.getString("key").toLowerCase()
            if (key.contains("VWS".toLowerCase())) {
                val dataID = categoryObject.getInt("id")
                val dataKey = categoryObject.getString("key")
                val karatMessage = categoryObject.getString("karatMessage")
                val titleID = categoryObject.getInt("title_id")
                val categoryID = categoryObject.getInt("category_id")

                val dataModel = DataModel()
                dataModel.id = dataID
                dataModel.key = dataKey
                dataModel.karatMessage = karatMessage
                dataModel.titleID = titleID
                dataModel.categoryID = categoryID

                val titleInputStream = assets.open("json/up normal/titles.json")

                val titleSize = titleInputStream.available()

                val titleBuffer = ByteArray(titleSize)
                titleInputStream.read(titleBuffer)
                titleInputStream.close()

                val titleJsonString = String(titleBuffer, charset("UTF-8"))

                val titleJsonArray = JSONArray(titleJsonString)


                for (j in 0 until titleJsonArray.length()) {
                    val titleObject = titleJsonArray.getJSONObject(j)

                    val id = titleObject.getInt("id")
                    if (id == titleID) {
                        dataModel.titleName = titleObject.getString("name")
                    }
                }

                problems.add(dataModel)

            }
        }

        problemsRV.adapter = VoiceAdapter(this@CategoriesActivity, problems)
    }

    private fun getProblems(jsonArray: JSONArray) {
        val problems = ArrayList<CategoryModel>()

        for (i in 0 until jsonArray.length()) {
            val categoryObject = jsonArray.getJSONObject(i)

            val id = categoryObject.getInt("id")
            val name = categoryObject.getString("name")
//
            val newCategory = CategoryModel()
            newCategory.id = id
            newCategory.name = name

            problems.add(newCategory)
        }

        problemsRV.adapter = CategoriesAdapter(this@CategoriesActivity, problems, normal)
    }

}
