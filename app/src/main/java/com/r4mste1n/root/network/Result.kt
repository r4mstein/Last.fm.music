package com.r4mste1n.root.network

/**
 * Created by Alex Shtain on 10.12.2019.
 */
sealed class Result<out T : Any> {

    class Success<out T : Any>(val data: T) : Result<T>()

    class Error(val message: String) : Result<Nothing>()

    class CodeError(val code: String?, val message: String) : Result<Nothing>()

}