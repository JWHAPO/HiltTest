package com.example.hilttest.service

import com.example.hilttest.common.Constants
import com.example.hilttest.network.DogResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by jwkimStation3 on 2021/08/23.
 * Description:
 */
interface DogService {
    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>
}