package com.hermes.caustic.core.api.models

data class Data(
    val changelogs: List<Changelog>,
    val count: Int,
    val page: Int,
    val pages: Int,
    val widget: Widget
)