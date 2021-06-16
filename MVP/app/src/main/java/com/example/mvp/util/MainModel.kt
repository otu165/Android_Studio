package com.example.mvp.util

/**
 * <Model>
 * Database 역할 수행
 */

data class MainModel(
    var appName: String,
    var appDownloads: Int,
    var appRating: Float
)