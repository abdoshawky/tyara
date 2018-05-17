package com.anwarboss.tyara.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.anwarboss.tyara.R
import com.anwarboss.tyara.adapters.MainSliderAdapter
import com.anwarboss.tyara.adapters.PlanesAdapter
import com.anwarboss.tyara.models.PlaneModel
import com.anwarboss.tyara.utils.PicassoImageLoadingService
import kotlinx.android.synthetic.main.activity_main.*
import ss.com.bannerslider.Slider

class MainActivity : AppCompatActivity() {

    var index: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "Check List"

        Slider.init(PicassoImageLoadingService())

        slider.setAdapter(MainSliderAdapter())
        slider.setOnSlideClickListener { position ->
            index = position

            val image = when (position) {
                0 -> R.drawable.rsz_one
                1 -> R.drawable.rsz_two
                2 -> R.drawable.rsz_three
                3 -> R.drawable.rsz_four
                4 -> R.drawable.rsz_five
                5 -> R.drawable.rsz_six
                6 -> R.drawable.rsz_seven
                7 -> R.drawable.rsz_eight
                8 -> R.drawable.rsz_nine
                9 -> R.drawable.rsz_ten
                10 -> R.drawable.rsz_eleven
                else -> R.drawable.rsz_twelve
            }

            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            intent.putExtra("image", image)
            intent.putExtra("index", index!!)
            startActivity(intent)

        }

//        logoIV.setOnClickListener {
//            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
//        }

        val planes: MutableList<PlaneModel> = ArrayList()
        planes.add(PlaneModel("Normal", R.drawable.green_plane))
        planes.add(PlaneModel("Up Normal", R.drawable.red_plane))
        planes.add(PlaneModel("Voice Warning", R.drawable.orange_plane))
        planes.add(PlaneModel("Search", R.drawable.yellow_plane))

        val planesAdapter = PlanesAdapter(this@MainActivity, planes)

        planesGV.adapter = planesAdapter
        planesGV.setOnItemClickListener { _, _, position, _ ->

            val category = planesAdapter.getItem(position)

            if (category == "Search") {
                startActivity(Intent(this@MainActivity, SearchActivity::class.java))
            } else {
                if (category == "Up Normal") {
                    val intent = Intent(this@MainActivity, CategoriesActivity::class.java)
                    intent.putExtra("category", category.toString())
                    startActivity(intent)
                } else if (category == "Voice Warning") {
                    val intent = Intent(this@MainActivity, CategoriesActivity::class.java)
                    intent.putExtra("category", category.toString())
                    startActivity(intent)
                } else {
                    val intent = Intent(this@MainActivity, CategoriesActivity::class.java)
                    intent.putExtra("category", category.toString())
                    startActivity(intent)
                }

//                val intent = Intent(this@MainActivity, CategoriesActivity::class.java)
//                intent.putExtra("category", category.toString())
//                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }
        }

        return true
    }

}
