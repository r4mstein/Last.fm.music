package com.r4mste1n.root.network

import com.google.gson.JsonParser
import okhttp3.ResponseBody


/**
 * Created by Alex Shtain on 18.04.2020.
 */
object ErrorUtils {

    fun parseError(response: ResponseBody?): String? {
        val errorJsonString = response?.string()

        return when {
            errorJsonString.isNullOrEmpty() -> null
            else -> {
                try {
                    JsonParser.parseString(errorJsonString)
                        .asJsonObject["message"]
                        .asString
                } catch (exception: Exception) {
                    null
                }
            }
        }
    }

}
