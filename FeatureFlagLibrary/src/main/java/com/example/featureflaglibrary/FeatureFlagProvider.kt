package com.example.featureflaglibrary

import android.content.Context
import com.example.featureflaglibrary.FeatureFlagManager

class FeatureFlagProvider {
    lateinit var flagManager: FeatureFlagManager

    fun init(applicationContext: Context) {
        flagManager = FeatureFlagManager()
        flagManager.init(context = applicationContext)
    }

    fun setKeyValue(key: String, value: Boolean) {
        flagManager.setKeyValue(key, value)
    }

    fun getValue(key: String): Boolean {
        return flagManager.getValue(key)
    }
}