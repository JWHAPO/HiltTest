package com.example.hilttest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by jwkimStation3 on 2021/06/15.
 * Description:
 */
@HiltAndroidApp
class DogApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: DogApplication? = null

        fun getContext(): DogApplication {
            return instance as DogApplication
        }
    }
}