package com.example.hilttest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hilttest.common.BaseViewModel
import com.example.hilttest.common.SingleLiveEvent
import com.example.hilttest.common.resCollect
import com.example.hilttest.network.DogResponse
import com.example.hilttest.repo.DogRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by jwkimStation3 on 2021/08/23.
 * Description:
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DogRepositoryImpl
) : BaseViewModel() {

    private val _response: MutableLiveData<DogResponse> = MutableLiveData()
    val response: LiveData<DogResponse> = _response

    val isLoading = SingleLiveEvent<Boolean>()
    val isError = SingleLiveEvent<Unit>()

    fun fetchDogResponse() = viewModelScope.launch {
        isLoading.value = true
        repository.getDog().resCollect(
            onSuccess = {
                _response.value = it
                isLoading.value = false
            },
            onError = {
                isLoading.value = false
                isError.call()
            }
        )
    }
}