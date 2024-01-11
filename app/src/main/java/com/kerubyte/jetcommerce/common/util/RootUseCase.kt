package com.kerubyte.jetcommerce.common.util

interface RootUseCase<in I, O : Any> {
    suspend operator fun invoke(input: I? = null): RemoteResponse<O>
}