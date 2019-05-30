package com.guilla.lab.shadows

import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonSyntaxException

import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.annotation.RealObject

import android.util.Log

import java.io.Reader
import java.lang.reflect.Type

import org.robolectric.internal.Shadow.directlyOn

/**
 * Created by ivan on 20/10/15.
 */
@Implements(Gson::class)
class ShadowGson {

    /**
     * Real object that will be injected when shadow is constructed.
     */
    @RealObject
    private val gson: Gson? = null

    /**
     * Shadowed constructor.
     */
    fun __constructor__() {

    }

    @Implementation
    @Throws(JsonIOException::class, JsonSyntaxException::class)
    fun <T> fromJson(json: Reader, typeOfT: Type): T {
        //Log that we're deserializing an object.
        Log.d("GsonShadow", "Deserializing $typeOfT")

        //Use directlyOn to invoke a shadowed method directly on a
        //Real object. Otherwise you'll get stack overflow exception.
        return directlyOn(gson, Gson::class.java).fromJson(json, typeOfT)
    }
}
