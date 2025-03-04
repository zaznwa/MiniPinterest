package com.geeks.minipinterest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.geeks.minipinterest.databinding.ActivityMainBinding
import com.geeks.minipinterest.view.adapters.ApiAdapter
import com.geeks.minipinterest.viewmodel.ApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = ApiAdapter()

    private val viewModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        viewModel.getImages("49146642-7c144c651dbd4d50aa8738874", "Bishkek")
        viewModel.getWeather("c598adc060934743b02110305251602", "Bishkek")

        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerView.adapter = adapter

            viewModel.images.observe(this@MainActivity) { response ->
                adapter.submitList(response.hits)
            }

            temperature.text = viewModel.weather.value?.current?.tempC.toString()

            viewModel.weather.observe(this@MainActivity) { response ->
                temperature.text = response.current?.tempC.toString()
            }
        }
    }
}