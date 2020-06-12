package com.example.kotlin.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransferResponse<T>(
        @JsonProperty("headerResp") val headerResponse: HeaderResponse,
        val content: T
)

data class HeaderResponse(
        var reqID: String,
        var reqDtm: String,
        var txnRefID: String? = null,
        var service: String,
        var statusCd: String,
        var statusDesc: String
)