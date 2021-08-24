package com.example.hilttest.common

import android.widget.Toast
import com.example.hilttest.DogApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 * Created by jwkimStation3 on 2021/08/24.
 * Description:
 */

suspend fun <T> Flow<T>.resCollect(
    onError: (String?) -> Unit = {},
    onSuccess: (T) -> Unit
) {
    flowOn(Dispatchers.IO)
        .catch { e ->
            onResException(
                exception = e,
                onError = onError
            )
        }.collect {
            onSuccess(it)
        }
}

private fun onResException(
    exception: Throwable,
    onError: (String?) -> Unit
) {
    commonError(onError, exception.message)
}

private fun commonError(onError: (String?) -> Unit, msg: String? = null) {
    onError(msg)
    showErrorToast(msg ?: COMMON_ERROR_MSG)
}

private fun showErrorToast(msg: String = "") {
    CoroutineScope(Dispatchers.Main).launch {
        Toast.makeText(
            DogApplication.getContext(),
            if (msg.isEmpty()) COMMON_ERROR_MSG
            else msg,
            Toast.LENGTH_LONG
        ).show()
        cancel()
    }
}

const val COMMON_ERROR_MSG = "에러가 발생하였습니다."