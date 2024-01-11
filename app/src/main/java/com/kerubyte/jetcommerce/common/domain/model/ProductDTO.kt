package com.kerubyte.jetcommerce.common.domain.model

data class ProductDTO(
    val id: Int = 0,
    val category_id: List<Int> = emptyList(),
    val brand: String = "",
    val colour_group_id: Int = 0,
    val description: String = "",
    val image_url: String = "",
    val name: String = "",
    val price: Double = 0.00,
    val size: String = "",
    val type: String = ""
)

fun ProductDTO.mapToProduct(): Product {
    return Product(
        id = this.id,
        categoryId = this.category_id,
        brand = this.brand,
        colourGroupId = this.colour_group_id,
        description = this.description,
        imageUrl = this.image_url,
        name = this.name,
        price = this.price.toBigDecimal(),
        formattedPrice = this.price.toString(),
        size = this.size
    )
}

fun List<ProductDTO>.mapToProductList(): List<Product> {
    return this.map { productDTO ->
        productDTO.mapToProduct()
    }
}
