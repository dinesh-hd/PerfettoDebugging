package com.codeaid.perfettodebugging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codeaid.perfettodebugging.repo.CountryRepo

class MainActivity : AppCompatActivity() {

     lateinit var itemList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemList = findViewById(R.id.item_list)

        CountryRepo(this).getCountries().observe(this, Observer {
            var adapter = ItemsAdapter(it)

            itemList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            itemList.adapter = adapter
        })
    }
}