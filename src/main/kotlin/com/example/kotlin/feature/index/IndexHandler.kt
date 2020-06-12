package com.example.kotlin.feature.index

import com.example.kotlin.dto.TransferRequest
import com.example.kotlin.feature.index.service.IndexService
import com.example.kotlin.utils.transferResponseSuccess
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.awaitBody

@Component
class IndexHandler (
    private val indexService: IndexService
){
    suspend fun getString(request : ServerRequest) =
        request.awaitBody<TransferRequest<String?>>().let{
            indexService.indexTest()
            transferResponseSuccess(
                headerRequest = it.headerRequest,
                response =  null
            )
        }
}