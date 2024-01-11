package com.kerubyte.jetcommerce.feature.listing.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kerubyte.jetcommerce.common.util.RemoteResponse
import com.kerubyte.jetcommerce.feature.listing.domain.GetAllProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel
@Inject constructor(
    private val getAllProductsUseCase: GetAllProducts
) : ViewModel() {
    var state by mutableStateOf(ListingScreenState())
        private set

    private fun getAllProducts() {
        viewModelScope.launch {
            state = state.copy(
                loading = true, error = null
            )
            state = when (val response = getAllProductsUseCase()) {
                is RemoteResponse.Success -> {
                    state.copy(
                        loading = false, data = response.data, error = null
                    )
                }

                is RemoteResponse.Error -> {
                    state.copy(
                        loading = false, data = null, error = response.message
                    )
                }
            }
        }
    }

    init {
        getAllProducts()
    }
}