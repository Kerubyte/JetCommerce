package com.kerubyte.jetcommerce.common.ui.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kerubyte.jetcommerce.common.util.Constants.PRODUCT_ID
import com.kerubyte.jetcommerce.feature.listing.presentation.ListingScreen
import com.kerubyte.jetcommerce.feature.listing.presentation.ListingViewModel

@Composable
fun NavController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListingScreen.route) {
        composable(
            Screen.ListingScreen.route
        ) {
            val listingVm: ListingViewModel = hiltViewModel()
            val state = listingVm.state
            ListingScreen(
                navController = navController,
                state = state
            )
        }
        composable(
            Screen.DetailScreen.route + "/{$PRODUCT_ID}",
            arguments = listOf(
                navArgument(PRODUCT_ID) {
                    type = NavType.IntType
                }
            )
        ) {
          /*  DetailScreen(
                navController = navController
            )*/
        }
    }
}