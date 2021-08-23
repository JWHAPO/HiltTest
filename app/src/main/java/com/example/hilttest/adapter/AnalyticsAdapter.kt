package com.example.hilttest.adapter

import com.example.hilttest.service.AnalyticsService
import javax.inject.Inject

/**
 * Created by jwkimStation3 on 2021/06/15.
 * Description:
 */
class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
) {
}