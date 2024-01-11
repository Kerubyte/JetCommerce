package com.kerubyte.jetcommerce.feature.detail.domain

import com.kerubyte.jetcommerce.common.domain.data.ProductRepository
import com.kerubyte.jetcommerce.common.domain.model.Product
import com.kerubyte.jetcommerce.common.util.RemoteResponse
import com.kerubyte.jetcommerce.common.util.RootUseCase
import javax.inject.Inject

class GetProductById
@Inject
constructor(
    private val productRepository: ProductRepository
) : RootUseCase<Int, Product> {
    override suspend fun invoke(input: Int?): RemoteResponse<Product> {
        if (input != null) {
            return when (val result = productRepository.getProductById(input)) {
                null -> RemoteResponse.Error.NetworkError(
                    message = "Couldn't find product"
                )
                else -> RemoteResponse.Success(
                    data = result
                )
            }
        }
        return RemoteResponse.Error.BadRequestError(
            message = "Product ID cannot be null"
        )
    }
}