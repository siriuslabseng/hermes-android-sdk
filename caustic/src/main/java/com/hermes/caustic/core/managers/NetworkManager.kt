package com.hermes.caustic.core.managers

import com.hermes.caustic.core.api.APIClient
import com.hermes.caustic.core.api.models.FetchChangelogResponse
import retrofit2.Call

class NetworkManager {

    fun fetchChangelogs(publicKey: String, widgetSlug: String) : Call<FetchChangelogResponse> {
        return APIClient.apiService.fetchChangelog(publicKey, widgetSlug)
    }

}