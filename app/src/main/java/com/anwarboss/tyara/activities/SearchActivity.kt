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

    private val titles = ArrayList<TitleModel>()
    private var titlesAdapter: TitlesAdapter? = null

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
                    R.id.karatBTN -> karat()
                }
                return true
            }
        })

        segmented.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.sectionsBTN -> searchSections()
                R.id.voiceBTN -> searchVoice()
                R.id.karatBTN -> karat()
            }
        }

        val inputStream = assets.open("json/up normal/titles.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        titlesArray = JSONArray(jsonString)

        searchRV.layoutManager = LinearLayoutManager(this@SearchActivity)

    }

    private fun searchSections() {
        titles.clear()

        if (searchQuery.trim().isEmpty()) {
            if (titlesAdapter != null) {
                titlesAdapter!!.notifyDataSetChanged()
            }        } else {
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
            if (titlesAdapter == null) {
                titlesAdapter = TitlesAdapter(this@SearchActivity, titles, false)
                searchRV.adapter = titlesAdapter
            } else {
                titlesAdapter!!.notifyDataSetChanged()
            }
        }
    }

    private fun searchVoice() {
        val inputStream = assets.open("json/up normal/data.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        val dataArray = JSONArray(jsonString)

        titles.clear()

        if (searchQuery.trim().isEmpty()) {
            if (titlesAdapter != null) {
                titlesAdapter!!.notifyDataSetChanged()
            }
        } else {

            for (i in 0 until dataArray.length()) {
                val data = dataArray.getJSONObject(i)

                val key = data.getString("key").toLowerCase()
                val karatMessage = data.getString("karatMessage")
                val titleID = data.getInt("title_id")

                if (karatMessage.toLowerCase().contains(searchQuery.toLowerCase()) && key.contains("vws")) {
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

            if (titlesAdapter == null) {
                titlesAdapter = TitlesAdapter(this@SearchActivity, titles, false)
                searchRV.adapter = titlesAdapter
            } else {
                titlesAdapter!!.notifyDataSetChanged()
            }
        }

    }

    private fun karat() {
        val inputStream = assets.open("json/up normal/data.json")

        val size = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, charset("UTF-8"))

        val dataArray = JSONArray(jsonString)

        titles.clear()

        if (searchQuery.trim().isEmpty()) {
            println("doone")
            if (titlesAdapter != null) {
                titlesAdapter!!.notifyDataSetChanged()
            }
        } else {

            for (i in 0 until dataArray.length()) {
                val data = dataArray.getJSONObject(i)

                val key = data.getString("key").toLowerCase()
                val karatMessage = data.getString("karatMessage")
                val titleID = data.getInt("title_id")
//            val section = data.getInt("section_id")

                if (karatMessage.toLowerCase().contains(searchQuery) && key.contains("mfd")) {
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

            if (titlesAdapter == null) {
                titlesAdapter = TitlesAdapter(this@SearchActivity, titles, false)
                searchRV.adapter = titlesAdapter
            } else {
                titlesAdapter!!.notifyDataSetChanged()
            }
        }
    }
}
