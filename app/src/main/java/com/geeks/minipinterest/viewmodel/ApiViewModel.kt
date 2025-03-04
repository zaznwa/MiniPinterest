package com.geeks.minipinterest.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.minipinterest.model.core.Either
import com.geeks.minipinterest.model.models.ApiResponse
import com.geeks.minipinterest.model.models.WeatherResponse
import com.geeks.minipinterest.model.repository.ApiRepository
import com.geeks.minipinterest.model.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ApiViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _images = MutableLiveData<ApiResponse>()
    val images: LiveData<ApiResponse> get() = _images

    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> get() = _weather

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> get() = _event

    fun getWeather(apiKey: String, query: String) {
        viewModelScope.launch {
            when (val response = weatherRepository.getWeather(apiKey, query)) {
                is Either.Success -> _weather.postValue(response.data)
                is Either.Error -> _event.postValue(Event.Error("${response.error.message}"))
            }
        }
    }

    fun getImages(key: String, query: String) {
        viewModelScope.launch {
            when (val response = apiRepository.getImages(key, query)) {
                is Either.Success -> _images.postValue(response.data)
                is Either.Error -> _event.postValue(Event.Error("${response.error.message}"))
            }
        }
    }

    sealed class Event {
        data class Error(val message: String) : Event()
    }

}