package com.guilla.lab.db.data.converter

import android.arch.persistence.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guilla.lab.Model.License
import com.guilla.lab.Model.Owner

import java.lang.reflect.Type

/*
 *  Room NestedItemConverter : Use in Entity.
 * */

class NestedLicenceConverter {
     var gson = Gson()
     var type = object : TypeToken<License>() {

    }.type

    @TypeConverter
    fun stringToNestedData(json: String): License {
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nestedDataToString(nestedData: License): String {
        return gson.toJson(nestedData, type)
    }
}