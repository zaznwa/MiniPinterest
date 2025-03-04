package com.geeks.minipinterest.model.repository

import android.util.Log
import com.geeks.minipinterest.model.core.Either
import com.geeks.minipinterest.model.models.WeatherResponse
import com.geeks.minipinterest.model.service.WeatherApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: WeatherApiService,
) {
    suspend fun getWeather(apiKey: String, query: String): Either<Throwable, WeatherResponse> {
        return try {
            val response = apiService.getWeather(apiKey, query)
            Either.Success(response)
        } catch (e: Throwable) {
            Either.Error(e)
        }
    }
}