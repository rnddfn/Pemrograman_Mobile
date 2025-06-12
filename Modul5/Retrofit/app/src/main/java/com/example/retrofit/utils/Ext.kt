package com.example.retrofit.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow

suspend fun <T> Flow<Response<T>>.collectAndHandle(
    onError: (Throwable) -> Unit = { throwable ->
        Log.e("collectAndHandle", "Error: ", throwable)
    },
    onLoading: () -> Unit = {},
    stateReducer: (T) -> Unit,
) {
    collect { response ->
        when (response) {
            is Response.Loading -> onLoading()
            is Response.Success -> stateReducer(response.data)
            is Response.Error -> {
                val error = response.error ?: Exception("Unknown error occurred")
                onError(error)
            }
        }
    }
}