package com.example.demo.config

import com.example.demo.konfig.SeaTableConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(private val seaTableConfig: SeaTableConfig) {

    @Bean
    fun seaTableApiClient(): WebClient {
        return WebClient.builder()
            .baseUrl(seaTableConfig.dtableDb)
            .defaultHeader("Authorization", "Token ${seaTableConfig.accessToken}")
            .build()
    }
}
