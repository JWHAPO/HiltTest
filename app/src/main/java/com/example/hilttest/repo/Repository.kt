package com.example.hilttest.repo

import com.example.hilttest.network.BaseApiResponse
import com.example.hilttest.network.DogResponse
import com.example.hilttest.network.NetworkResult
import com.example.hilttest.network.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by jwkimStation3 on 2021/08/23.
 * Description:
 */
@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    BaseApiResponse() {
    suspend fun getDog(): Flow<NetworkResult<DogResponse>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getDog() })
        }.flowOn(Dispatchers.IO)
    }
}