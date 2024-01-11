package com.kerubyte.jetcommerce.common.ui.nav

import com.kerubyte.jetcommerce.common.util.Constants.ROUTE_DETAIL
import com.kerubyte.jetcommerce.common.util.Constants.ROUTE_HOME
import com.kerubyte.jetcommerce.common.util.Constants.ROUTE_LISTING

sealed class Screen(val route: String) {
    object HomeScreen : Screen(route = ROUTE_HOME)
    object ListingScreen : Screen(route = ROUTE_LISTING)
    object DetailScreen : Screen(route = ROUTE_DETAIL)

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
