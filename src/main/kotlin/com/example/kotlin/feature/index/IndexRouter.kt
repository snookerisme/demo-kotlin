package com.example.kotlin.feature.index

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class IndexRouter {

    @Bean
    fun getIndexRoutes(
            indexHandler: IndexHandler
    ) = coRouter {
            accept(MediaType.APPLICATION_JSON).nest{
                POST("/index",  indexHandler::getString)
            }
        }

}