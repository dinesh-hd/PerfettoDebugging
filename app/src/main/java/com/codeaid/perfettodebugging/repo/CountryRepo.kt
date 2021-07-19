package com.codeaid.perfettodebugging.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codeaid.perfettodebugging.R
import com.codeaid.perfettodebugging.datamodel.Countries
import com.codeaid.perfettodebugging.datamodel.Country
import com.google.gson.Gson

class CountryRepo(context: Context){

    private val ctx = context
    private val countries : MutableLiveData<List<Country>> = MutableLiveData()

    fun fetchCountries() {
        val iStream = ctx.resources.openRawResource(R.raw.reso)
        var rawText = iStream.bufferedReader().use { it.readText() }
        rawText = rawText.trim().replace("\r", "").replace("\n", "")
        val allCountries = Gson().fromJson(rawText, Countries::class.java)
        countries.value = allCountries.countries
    }

    fun getCountries() : LiveData<List<Country>>{
        if(countries.value.isNullOrEmpty()){
            fetchCountries()
        }
        return  countries
    }
}