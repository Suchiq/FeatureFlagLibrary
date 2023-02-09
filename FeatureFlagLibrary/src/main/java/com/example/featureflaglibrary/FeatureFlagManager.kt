package com.example.featureflaglibrary

import android.content.Context
import android.content.SharedPreferences


class FeatureFlagManager : FeatureFlag {
    lateinit var sharedPref: SharedPreferences

    companion object {
        const val feature = "feature"
    }

    fun init(context: Context) {
        sharedPref = context?.getSharedPreferences(
            feature, Context.MODE_PRIVATE
        )!!
    }

    override fun setKeyValue(key: String, value: Boolean) {
        sharedPref.edit().putBoolean(key, value).commit()
    }

    override fun getValue(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }
}