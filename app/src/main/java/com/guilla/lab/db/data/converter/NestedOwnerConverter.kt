package com.guilla.lab.db.data.converter

import android.arch.persistence.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guilla.lab.Model.Owner

import java.lang.reflect.Type

/*
 *  Room NestedItemConverter : Use in Entity.
 * */

class NestedOwnerConverter {
     var gson = Gson()
     var type = object : TypeToken<Owner>() {

    }.type

    @TypeConverter
    fun stringToNestedData(json: String): Owner {
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nestedDataToString(nestedData: Owner): String {
        return gson.toJson(nestedData, type)
    }
}