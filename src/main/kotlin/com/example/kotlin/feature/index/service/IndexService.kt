package com.example.kotlin.feature.index.service

import org.springframework.stereotype.Service

@Service
class IndexService (){

    suspend fun indexTest(): String? = "TEST DEMO KOTLIN ^^!"
}
