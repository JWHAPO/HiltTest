package com.example.hilttest.repo

import com.example.hilttest.network.DogResponse
import com.example.hilttest.service.DogService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by jwkimStation3 on 2021/08/23.
 * Description:
 */
@ActivityRetainedScoped
class DogRepositoryImpl @Inject constructor(private val dogService: DogService) :
    DogRepository {
    override suspend fun getDog(): Flow<DogResponse> {
        return flow {
            emit(dogService.getDog())
        }
    }
}