package com.example.demo.seatable

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class SeaTableApiClient {

    fun getAppAccessToken(): String {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://cloud.seatable.io/api/v2.1/dtable/app-access-token/")
            .get()
            .addHeader("accept", "application/json")
            .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTA0OTAyNzUsImR0YWJsZV91dWlkIjoiYzJmOTA3MDYtMmQxYS00NzMzLWJkODktM2FiZTRjNGQ0ZmU1IiwidXNlcm5hbWUiOiIiLCJwZXJtaXNzaW9uIjoicnciLCJhcHBfbmFtZSI6IkJyYWluV2F2ZSJ9.9K9o1Y8cm6ldwE4lpXMHVAFDjkka5yEvCc-rlZsLLdE") // Замените YOUR_ACCESS_TOKEN на ваш реальный токен доступа API SeaTable
            .build()

        val response = client.newCall(request).execute()

        if (!response.isSuccessful) {
            throw RuntimeException("Failed to get app access token from SeaTable")
        }

        return response.body?.string() ?: throw RuntimeException("Empty response body")
    }

    // Переименуйте бин внутри класса
    @Bean(name = ["seaTableApiClientBean"])
    fun seaTableApiClientBean(): SeaTableApiClient {
        return SeaTableApiClient()
    }
}
