package com.kerubyte.jetcommerce.feature.listing.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kerubyte.jetcommerce.common.domain.model.Product

@Composable
fun ListingGrid(
    data: List<Product>,
    onItemClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    val gridState = rememberLazyGridState()
    LazyVerticalGrid(
        state = gridState,
        columns = GridCells.Fixed(2)
    ) {
        items(data) { product ->
            GridItem(
                item = product,
                onItemClick = onItemClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GridItem(
    item: Product,
    onItemClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onItemClick(item) },
        modifier = Modifier.padding(8.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.name,
                Modifier.fillMaxWidth()
            )
            Column(
                modifier
                    .fillMaxWidth()
                    .background(Color(243, 243, 245, 255))
                    .padding(8.dp)
            ) {
                Text(
                    text = item.name
                )
                Text(
                    text = item.brand
                )
                Text(
                    text = item.formattedPrice
                )
            }
        }
    }
}