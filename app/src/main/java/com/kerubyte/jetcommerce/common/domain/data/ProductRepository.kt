package com.kerubyte.jetcommerce.common.domain.data

import com.kerubyte.jetcommerce.common.domain.model.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>?
    suspend fun getProductById(id: Int): Product?
}