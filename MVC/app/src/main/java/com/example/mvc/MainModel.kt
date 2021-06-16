package com.example.mvc

/**
 * <Model>
 * Database 처럼 이용
 */

data class MainModel(
    var appName: String,
    var appDownloads: Int,
    var appRating: Float
) {

}