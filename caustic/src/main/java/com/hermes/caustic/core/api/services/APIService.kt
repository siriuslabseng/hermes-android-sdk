package com.hermes.caustic.core.api.services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @GET("/changelog/slug/{slug_id}")
    fun cancelCheckout(@Header("x-hermes-public-key") publicKey : String, @Path("slug_id") slugId : String) : Call<SubmitOTPResponse>

}