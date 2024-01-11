package com.kerubyte.jetcommerce.common.domain.model

import java.math.BigDecimal

data class Product(
    val id: Int,
    val categoryId: List<Int>,
    val brand: String,
    val colourGroupId: Int,
    val description: String,
    val imageUrl: String,
    val name: String,
    val price: BigDecimal,
    val formattedPrice: String,
    val size: String
)
