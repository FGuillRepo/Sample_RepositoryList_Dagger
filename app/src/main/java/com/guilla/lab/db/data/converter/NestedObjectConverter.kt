package com.guilla.lab.db.data.converter

import android.arch.persistence.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guilla.lab.Model.License
import com.guilla.lab.Model.Owner

import java.lang.reflect.Type
import java.util.*

/*
 *  Room NestedItemConverter : Use in Entity.
 * */

class NestedObjectConverter {
     var gson = Gson()
     var type = object : TypeToken<Any>() {

    }.type

    @TypeConverter
    fun stringToNestedData(json: String): Any {
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nestedDataToString(nestedData: Any): String {
        return gson.toJson(nestedData, type)
    }
}