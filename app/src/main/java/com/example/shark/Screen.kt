package com.example.shark


/*
sealed class Screen (val route: String) {
    data object Landing: Screen("landing_screen")
    data object Dashboard: Screen("dashboard_screen")
    data object Product: Screen("product_screen")
}
*/
sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object Account:Screen("account")
    object Registration : Screen("registration")
    object Product : Screen("product/{productName}") { // Add argument for product name
        fun createRoute(productName: String) = "product/$productName"
    }
}

