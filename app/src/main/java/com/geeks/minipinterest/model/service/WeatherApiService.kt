package com.geeks.minipinterest.model.service

import com.geeks.minipinterest.model.models.ApiResponse
import com.geeks.minipinterest.model.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("https://api.weatherapi.com/v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") query: String,
    ): WeatherResponse
}