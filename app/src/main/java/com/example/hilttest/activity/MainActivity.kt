package com.example.hilttest.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.hilttest.databinding.ActivityMainBinding
import com.example.hilttest.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by jwkimStation3 on 2021/06/15.
 * Description:
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData()

        mainViewModel.isLoading.observe(this){
            _binding.pgBar.isVisible = it
        }

        mainViewModel.isError.observe(this){
            _binding.clEmpty.isVisible = true
        }
    }

    private fun fetchData() {
        mainViewModel.fetchDogResponse()
        mainViewModel.response.observe(this) {
            it?.let { data ->
                _binding.ivImage.load(
                    data.message
                ) {
                    transformations(RoundedCornersTransformation(16f))
                }
            }
        }
    }
}