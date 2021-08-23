package com.example.hilttest.network

import com.example.hilttest.service.DogService
import javax.inject.Inject

/**
 * Created by jwkimStation3 on 2021/08/23.
 * Description:
 */
class RemoteDataSource @Inject constructor(private val dogService: DogService) {
    suspend fun getDog() = dogService.getDog()
}