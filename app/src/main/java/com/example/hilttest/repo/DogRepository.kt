package com.example.hilttest.repo

import com.example.hilttest.network.DogResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by jwkimStation3 on 2021/08/24.
 * Description:
 */
interface DogRepository {
    suspend fun getDog(): Flow<DogResponse>
}