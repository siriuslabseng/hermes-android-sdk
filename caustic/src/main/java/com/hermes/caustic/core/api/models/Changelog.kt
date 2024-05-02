package com.hermes.caustic.core.api.models

data class Changelog(
    val __v: Int,
    val _id: String,
    val app: String,
    val author: Author,
    val company: String,
    val content: String,
    val createdAt: String,
    val fireReaction: Int,
    val heartReaction: Int,
    val smileReaction: Int,
    val sobReaction: Int,
    val status: String,
    val thumbsDownReaction: Int,
    val thumbsUpReaction: Int,
    val title: String,
    val updatedAt: String
)