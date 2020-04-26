package com.r4mste1n.root.network

import com.google.gson.JsonParser
import com.r4mste1n.root.network.NetworkConstants.DEFAULT_ERROR_MESSAGE
import okhttp3.ResponseBody


/**
 * Created by Alex Shtain on 18.04.2020.
 */
object ErrorUtils {

    fun parseError(response: ResponseBody?): String {
        val errorJsonString = response?.string()

        return when {
            errorJsonString.isNullOrEmpty() -> DEFAULT_ERROR_MESSAGE
            else -> {
                try {
                    JsonParser.parseString(errorJsonString)
                        .asJsonObject["message"]
                        .asString
                } catch (exception: Exception) {
                    DEFAULT_ERROR_MESSAGE
                }
            }
        }
    }

}
