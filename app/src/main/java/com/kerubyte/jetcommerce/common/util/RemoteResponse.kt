package com.kerubyte.jetcommerce.common.util

sealed class RemoteResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : RemoteResponse<T>(data)
    sealed class Error<T>(message: String?) : RemoteResponse<T>(null, message) {
        class NetworkError<T>(message: String?) : Error<T>(message)
        class AuthenticationError<T>(message: String?) : Error<T>(message)
        class BadRequestError<T>(message: String?) : Error<T>(message)
    }
}