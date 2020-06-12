package com.example.kotlin.utils

import com.example.kotlin.dto.HeaderRequest
import com.example.kotlin.dto.HeaderResponse
import com.example.kotlin.dto.ResponseStatus
import com.example.kotlin.dto.TransferResponse
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

suspend inline fun <T> transferResponseSuccess(headerResponse: HeaderResponse, response: T) =
        ServerResponse
                .ok()
                .json()
                .bodyValueAndAwait(
                        TransferResponse(
                                headerResponse,
                                response
                        )
                )


suspend inline fun <T> transferResponseSuccess(headerRequest: HeaderRequest, response: T) =
        ServerResponse
                .ok()
                .json()
                .bodyValueAndAwait(
                        TransferResponse(
                                buildHeaderResponse(
                                        headerRequest
                                ),
                                response
                        )
                )

fun buildHeaderResponse(
        headerRequest: HeaderRequest,
        responseStatus: ResponseStatus = ResponseStatus.SUCCESS
) = HeaderResponse(
        reqDtm = headerRequest.reqDtm.orEmpty(),
        reqID = headerRequest.reqID.orEmpty(),
        service = headerRequest.service.orEmpty(),
        statusCd = responseStatus.code,
        statusDesc = responseStatus.desc,
        txnRefID = headerRequest.txnRefID.orEmpty()
)