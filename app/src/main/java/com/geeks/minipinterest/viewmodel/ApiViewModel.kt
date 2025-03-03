package com.geeks.minipinterest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.minipinterest.model.core.Either
import com.geeks.minipinterest.model.models.ApiResponse
import com.geeks.minipinterest.model.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
) : ViewModel() {

    private val _images = MutableLiveData<List<ApiResponse.Hit>>()
    val images: LiveData<List<ApiResponse.Hit>> get() = _images

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> get() = _event

    fun getImages(key: String, query: String) {
        viewModelScope.launch {
            when (val response = apiRepository.getImages(key, query)) {
                is Either.Success -> _images.postValue(
                    response.data.hits as List<ApiResponse.Hit>? ?: emptyList())
                is Either.Error -> _event.postValue(Event.Error("${response.error.message}"))
            }
        }
    }

    sealed class Event {
        data class Error(val message: String) : Event()
    }

}