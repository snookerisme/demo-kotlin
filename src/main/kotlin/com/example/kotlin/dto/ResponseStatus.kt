package com.example.kotlin.dto


enum class ResponseStatus {
    SUCCESS {
        override var code: String = "0000"
        override var desc: String = "Success"
    };

    abstract var code: String
    abstract var desc: String
}
