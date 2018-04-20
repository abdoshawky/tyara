package com.anwarboss.tyara.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.SearchView
import com.anwarboss.tyara.R
import com.anwarboss.tyara.adapters.TitlesAdapter
import com.anwarboss.tyara.models.TitleModel
import kotlinx.android.synthetic.main.activity_search.*
import org.json.JSONArray

class SearchActivity : AppCompatActivity() {

    var searchQuery = ""
    private lateinit var titlesArray: JSONArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchQuery = newText!!
                val checkedId = segmented.checkedRadioButtonId

                when (checkedId) {
                    R.id.sectionsBTN -> searchSections()
                    R.id.voiceBTN -> searchVoice()
                    R.id.karatBTN -> searchKarat()
                }
                return true
            }
        })

        segmented.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {
                R.id.sectionsBTN -> searchSections()
                R.id.voiceBTN -> searchVoice()
                R.id.karatBTN -> searchKarat()
            }
        }

        val inputStream = assets.open("json/titles.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        titlesArray = JSONArray(jsonString)

        searchRV.layoutManager = LinearLayoutManager(this@SearchActivity)

    }

    private fun searchSections() {
        val titles = ArrayList<TitleModel>()

        for (i in 0 until titlesArray.length()) {
            val titleObject = titlesArray.getJSONObject(i)

            val id = titleObject.getInt("id")
            val name = titleObject.getString("name")
            val categoryID = titleObject.getInt("category_id")

            if (name.toLowerCase().contains(searchQuery)) {
                val title = TitleModel()
                title.id = id
                title.name = name
                title.categoryID = categoryID


                titles.add(title)
            }
        }

        searchRV.adapter = TitlesAdapter(this@SearchActivity, titles)

    }

    private fun searchVoice() {
        val inputStream = assets.open("json/data.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        val dataArray = JSONArray(jsonString)

        val titles = ArrayList<TitleModel>()

        for (i in 0 until dataArray.length()) {
            val data = dataArray.getJSONObject(i)

            val key = data.getString("key")
            val karatMessage = data.getString("karatMessage")
            val titleID = data.getInt("title_id")

            if (karatMessage.toLowerCase().contains(searchQuery) && key == "VWS") {
                for (j in 0 until titlesArray.length()) {
                    val titleObject = titlesArray.getJSONObject(j)

                    val id = titleObject.getInt("id")
                    val categoryID = titleObject.getInt("category_id")

                    if (id == titleID) {
                        val title = TitleModel()
                        title.id = id
                        title.name = karatMessage
                        title.categoryID = categoryID


                        titles.add(title)
                    }

                }
            }
        }

        searchRV.adapter = TitlesAdapter(this@SearchActivity, titles)


    }

    private fun searchKarat() {
        val inputStream2 = assets.open("json/sections.json")

        val size2 = inputStream2.available()

        val buffer2 = ByteArray(size2)
        inputStream2.read(buffer2)
        inputStream2.close()

        val jsonString2 = String(buffer2, charset("UTF-8"))

        val sectionsArray = JSONArray(jsonString2)


        for (i in 0 until sectionsArray.length()) {
            val sectionObject = sectionsArray.getJSONObject(i)

            val sectionName = sectionObject.getString("name")
            if (sectionName == "INDICATIONS") {
                karat(sectionObject.getInt("id"))
                break
            }
        }


    }

    private fun karat(sectionID: Int) {
        val inputStream = assets.open("json/data.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        val dataArray = JSONArray(jsonString)

        val titles = ArrayList<TitleModel>()

        for (i in 0 until dataArray.length()) {
            val data = dataArray.getJSONObject(i)

            val key = data.getString("key")
            val karatMessage = data.getString("karatMessage")
            val titleID = data.getInt("title_id")
            val section = data.getInt("section_id")

            if (karatMessage.toLowerCase().contains(searchQuery) && key == "Middle MFD" && section == sectionID) {
                for (j in 0 until titlesArray.length()) {
                    val titleObject = titlesArray.getJSONObject(j)

                    val id = titleObject.getInt("id")
                    val categoryID = titleObject.getInt("category_id")

                    if (id == titleID) {
                        val title = TitleModel()
                        title.id = id
                        title.name = karatMessage
                        title.categoryID = categoryID


                        titles.add(title)
                    }

                }
            }
        }

        searchRV.adapter = TitlesAdapter(this@SearchActivity, titles)


    }

}
