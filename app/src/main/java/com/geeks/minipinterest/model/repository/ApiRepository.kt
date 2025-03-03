package com.geeks.minipinterest.model.repository

import android.util.Log
import com.geeks.minipinterest.model.core.Either
import com.geeks.minipinterest.model.models.ApiResponse
import com.geeks.minipinterest.model.service.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getImages(key: String, query: String): Either<Throwable, ApiResponse> {
        return try {
            val response = apiService.getImages(key, query)
            Either.Success(response)
        } catch (e: Throwable) {
            Log.e("ololo", "getImages() returned error: $e", )
            Either.Error(e)
        }
    }
}