package com.hermes.caustic.core.api.models

data class FetchChangelogResponse(
    val `data`: Data,
    val message: String,
    val method: String,
    val status: Int
)