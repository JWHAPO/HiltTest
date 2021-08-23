package com.example.hilttest.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.hilttest.databinding.ActivityMainBinding
import com.example.hilttest.network.NetworkResult
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
    }

    private fun fetchData() {
        mainViewModel.fetchDogResponse()
        mainViewModel.response.observe(this) {
            when (it) {
                is NetworkResult.Success -> {
                    isPgShow(false)
                    it.data?.let { data ->
                        _binding.ivImage.load(
                            data.message
                        ) {
                            transformations(RoundedCornersTransformation(16f))
                        }
                    }
                }
                is NetworkResult.Error -> {
                    showToast(it.data?.message)
                    isPgShow(false)
                }
                is NetworkResult.Loading -> {
                    isPgShow(true)
                }
            }
        }
    }

    private fun isPgShow(isShow: Boolean) {
        _binding.pgBar.isVisible = isShow
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message ?: "에러가 발생했습니다.", Toast.LENGTH_LONG).show()
    }

}