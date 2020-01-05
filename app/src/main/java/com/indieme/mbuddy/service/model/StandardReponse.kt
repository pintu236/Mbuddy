package com.indieme.mbuddy.service.model

data class StandardReponse<T>(var response: T, var message: String, var status: Int)