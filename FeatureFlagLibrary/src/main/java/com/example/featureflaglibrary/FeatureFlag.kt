package com.example.featureflaglibrary

interface FeatureFlag {
    fun setKeyValue(key: String, value: Boolean)
    fun getValue(key: String): Boolean
}