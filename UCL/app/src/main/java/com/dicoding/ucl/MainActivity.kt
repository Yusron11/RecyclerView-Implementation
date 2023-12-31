package com.dicoding.ucl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private lateinit var rvClub: RecyclerView
    private val list = ArrayList<Club>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClub = findViewById(R.id.rv_club)
        rvClub.setHasFixedSize(true)

        list.addAll(getListClubs())
        showRecyclerList()

    }

    private fun getListClubs() : ArrayList<Club> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listClub = ArrayList<Club>()
        for (i in dataName.indices) {
            val club = Club (dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listClub.add(club)
        }
        return listClub
    }

    private fun showRecyclerList() {
        rvClub.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ListClubAdapter(list)
        rvClub.adapter = listClubAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> {
                val aboutIntent = Intent (this@MainActivity,About::class.java)
                startActivity(aboutIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }




}