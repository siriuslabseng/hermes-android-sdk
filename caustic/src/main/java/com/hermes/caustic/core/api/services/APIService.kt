package com.hermes.caustic.core.api.services

import com.hermes.caustic.core.api.models.FetchChangelogResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface APIService {

    @GET("changelog/slug/{slug_id}")
    fun fetchChangelog(@Header("x-hermes-public-key") publicKey : String, @Path("slug_id") slugId : String) : Call<FetchChangelogResponse>

}