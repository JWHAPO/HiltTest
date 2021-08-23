package com.example.hilttest.network

import com.google.gson.annotations.SerializedName

/**
 * Created by jwkimStation3 on 2021/08/23.
 * Description:
 */
data class DogResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)