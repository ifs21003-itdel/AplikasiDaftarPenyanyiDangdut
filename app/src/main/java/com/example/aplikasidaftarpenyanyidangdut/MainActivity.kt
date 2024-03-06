package com.example.aplikasidaftarpenyanyidangdut

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Penyanyi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Kode untuk membuat view dapat ditekan dan menampilkan activity detail penyanyi

//        val spannableString = SpannableString("List Pedangdut Asekk!!")
//        val colorSpan = ForegroundColorSpan(Color.parseColor("#FFFFFF"))
//        spannableString.setSpan(colorSpan, 0, spannableString.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        val actionBar = supportActionBar
//        actionBar?.title = spannableString
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#775177")))

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val intent = Intent(this@MainActivity,about_me::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Penyanyi> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataDescriptionPreview = resources.getStringArray(R.array.data_description_preview)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPenyanyi = ArrayList<Penyanyi>()
        for (i in dataName.indices) {
            val penyanyi = Penyanyi(dataName[i], dataDescription[i], dataDescriptionPreview[i], dataPhoto.getResourceId(i, -1))
            listPenyanyi.add(penyanyi)
        }
        return listPenyanyi
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listPenyanyiAdapter = ListPenyanyiAdapter(list)
        rvHeroes.adapter = listPenyanyiAdapter
        listPenyanyiAdapter.setOnItemClickListener(object : ListPenyanyiAdapter.onItemClisckListerner{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, DetailPenyanyi::class.java)
                intent.putExtra(DetailPenyanyi.EXTRA_NAME, list[position].name)
                intent.putExtra(DetailPenyanyi.EXTRA_DESCRIPTION, list[position].description)
                intent.putExtra(DetailPenyanyi.EXTRA_PHOTO, list[position].photo)
                startActivity(intent)
            }

        })

    }

}