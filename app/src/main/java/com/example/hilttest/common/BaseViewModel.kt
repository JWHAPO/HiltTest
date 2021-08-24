package com.example.hilttest.common

import androidx.lifecycle.ViewModel

/**
 * Created by jwkimStation3 on 2021/08/24.
 * Description:
 */
open class BaseViewModel: ViewModel() {
    fun doClickEvent(liveEvent: SingleLiveEvent<Unit>) = liveEvent.call()
}