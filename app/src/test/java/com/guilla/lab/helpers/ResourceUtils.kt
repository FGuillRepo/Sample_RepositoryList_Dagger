package com.guilla.lab.helpers

import java.io.InputStream
import java.util.Scanner

/**
 * Utility methods for accessing resources bundled with test APK. Standard Android Resources don't seem to work for test APK
 * (unable to fetch R.java).
 *
 *
 * Resources should be placed under /resources/mockdata folder in androidTest flavour. Use [.readFromFile] to read a text
 * file to String giving only a name of the file located in /resources/mockdata folder.
 */
object ResourceUtils {

    private val MOCK_DATA_DIRECTORY = "mockdata/%s"

    /**
     * Converts InputStream to String.
     */
    fun convertStreamToString(`is`: InputStream): String {
        val s = Scanner(`is`, "UTF-8").useDelimiter("\\A")
        return if (s.hasNext()) s.next() else ""
    }

    /**
     * Reads a resource file to `String`.
     */
    fun readFromFile(filename: String): String {
        val `is` = ResourceUtils::class.java!!.getClassLoader().getResourceAsStream(String.format(MOCK_DATA_DIRECTORY, filename))
        return convertStreamToString(`is`)
    }
}
