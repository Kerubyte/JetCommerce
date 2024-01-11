package com.kerubyte.jetcommerce.common.data

import com.kerubyte.jetcommerce.common.domain.data.DatabaseInteractor
import com.kerubyte.jetcommerce.common.domain.data.ProductRepository
import com.kerubyte.jetcommerce.common.domain.model.Product
import com.kerubyte.jetcommerce.common.domain.model.ProductDTO
import com.kerubyte.jetcommerce.common.domain.model.mapToProduct
import com.kerubyte.jetcommerce.common.domain.model.mapToProductList
import com.kerubyte.jetcommerce.common.util.Constants.COLLECTION_PRODUCTS
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl
@Inject constructor(
    private val databaseInteractor: DatabaseInteractor
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product>? {
        return withContext(Dispatchers.IO) {
            val result = databaseInteractor.getWholeCollection(COLLECTION_PRODUCTS).await()

            when {
                result.isEmpty -> null
                else -> {
                    result
                        .toObjects(ProductDTO::class.java)
                        .mapToProductList()
                }
            }
        }
    }

    override suspend fun getProductById(id: Int): Product? =
        withContext(Dispatchers.IO) {
            val result = databaseInteractor.getSingleDocument(COLLECTION_PRODUCTS, id).await()
            result.toObject(ProductDTO::class.java)?.mapToProduct()
        }
}