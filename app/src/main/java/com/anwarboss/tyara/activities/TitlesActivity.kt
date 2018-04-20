package com.anwarboss.tyara.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.anwarboss.tyara.R
import com.anwarboss.tyara.adapters.TitlesAdapter
import com.anwarboss.tyara.models.TitleModel
import kotlinx.android.synthetic.main.activity_problems.*
import org.json.JSONArray

class TitlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problems)

        val bundle = intent.extras

        val mainCategoryID = bundle.getInt("id")
        val titleName = bundle.getString("name")

        supportActionBar!!.title = titleName

        val inputStream = assets.open("json/titles.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        val jsonArray = JSONArray(jsonString)

        val titles = ArrayList<TitleModel>()

        for (i in 0 until jsonArray.length()) {
            val titleObject = jsonArray.getJSONObject(i)

            val id = titleObject.getInt("id")
            val name = titleObject.getString("name")
            val categoryID = titleObject.getInt("category_id")

            if (mainCategoryID == categoryID) {
                val title = TitleModel()
                title.id = id
                title.name = name
                title.categoryID = categoryID


                titles.add(title)
            }
        }

        problemsRV.layoutManager = LinearLayoutManager(this@TitlesActivity)
        problemsRV.adapter = TitlesAdapter(this@TitlesActivity, titles)

    }
}
