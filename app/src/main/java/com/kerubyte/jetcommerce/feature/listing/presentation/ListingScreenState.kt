package com.kerubyte.jetcommerce.feature.listing.presentation

import com.kerubyte.jetcommerce.common.domain.model.Product

data class ListingScreenState(
    val loading: Boolean = false,
    val data: List<Product>? = null,
    val error: String? = null
)
