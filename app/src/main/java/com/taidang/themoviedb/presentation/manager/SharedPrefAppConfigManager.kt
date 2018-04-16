package com.taidang.themoviedb.presentation.manager

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.taidang.themoviedb.domain.model.Country
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.extension.createType

class SharedPrefAppConfigManager(private val mPref: SharedPreferences, private val mGson: Gson)
    : AppConfigManager {

    companion object {
        const val PREF_IMAGES_CONFIG = "images-config"
        const val PREF_COUNTRIES = "countries"
        const val PREF_CURRENT_COUNTRY = "current-country"
    }

    override fun getImagesConfig(): ImagesConfig? {
        val json = mPref.getString(PREF_IMAGES_CONFIG, null)
        return if (json != null)
            mGson.fromJson(json, ImagesConfig::class.java)
        else
            null
    }

    override fun saveImagesConfig(imagesConfig: ImagesConfig?) {
        imagesConfig?.let {
            mPref.edit { putString(PREF_IMAGES_CONFIG, mGson.toJson(imagesConfig)) }
        }
    }

    override fun getCountries(): List<Country> {
        val json = mPref.getString(PREF_COUNTRIES, null)
        return if (json != null)
            mGson.fromJson(json, createType<List<Country>>())
        else
            listOf()
    }

    override fun saveCountries(countries: List<Country>) {
        mPref.edit { putString(PREF_COUNTRIES, mGson.toJson(countries)) }
    }

    override fun getCurrentCountry(): Country? {
        val json = mPref.getString(PREF_CURRENT_COUNTRY, null)
        return if (json != null) {
            mGson.fromJson(json, Country::class.java)
        } else {
            null
        }
    }

    override fun saveCurrentCountry(country: Country?) {
        country?.let {
            mPref.edit { putString(PREF_CURRENT_COUNTRY, mGson.toJson(country)) }
        }
    }
}