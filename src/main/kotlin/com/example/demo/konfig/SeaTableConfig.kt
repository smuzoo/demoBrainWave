package com.example.demo.konfig

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "seatable")
data class SeaTableConfig(
    val appName: String,
    val accessToken: String,
    val dtableUuid: String,
    val dtableServer: String,
    val dtableSocket: String,
    val dtableDb: String,
    val workspaceId: Int,
    val dtableName: String
)
