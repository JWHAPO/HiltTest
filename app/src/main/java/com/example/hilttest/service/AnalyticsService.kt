package com.example.hilttest.service

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

/**
 * Created by jwkimStation3 on 2021/06/15.
 * Description:
 */
interface AnalyticsService {
    fun analyticsMethods()
}

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService{
    override fun analyticsMethods() {
        //TODO("Not yet implemented")
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule{
    @Binds
    abstract fun bindAnalyticsService(
        analyticsServiceImpl: AnalyticsServiceImpl
    ): AnalyticsService

}