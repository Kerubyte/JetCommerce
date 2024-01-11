package com.kerubyte.jetcommerce.feature.listing.domain

import com.kerubyte.jetcommerce.common.domain.data.ProductRepository
import com.kerubyte.jetcommerce.common.domain.model.Product
import com.kerubyte.jetcommerce.common.util.RemoteResponse
import com.kerubyte.jetcommerce.common.util.RootUseCase
import javax.inject.Inject

class GetAllProducts
@Inject
constructor(
    private val productRepository: ProductRepository
) : RootUseCase<Any, List<Product>> {
    override suspend fun invoke(input: Any?): RemoteResponse<List<Product>> {
        val response = productRepository.getAllProducts()
        return when {
            response.isNullOrEmpty() -> {
                RemoteResponse.Error.NetworkError(message = "Smth went wrong, veri wrong")
            }
            else -> {
                RemoteResponse.Success(data = response)
            }
        }
    }
}