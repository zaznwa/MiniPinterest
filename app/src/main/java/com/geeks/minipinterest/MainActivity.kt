package com.geeks.minipinterest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
        viewModel.getImages("49146642-7c144c651dbd4d50aa8738874", "ferrari")
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerView.adapter = adapter

            viewModel.event.observe(this@MainActivity) { event ->
                when (event) {
                    is ApiViewModel.Event.Error -> {
                        Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            viewModel.images.observe(this@MainActivity) { response ->
                adapter.submitList(response)
            }

        }
    }
}