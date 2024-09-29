package com.example.shark
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shark.screen.AccountScreen
import com.example.shark.screen.DashboardScreen
import com.example.shark.screen.LandingScreen
import com.example.shark.screen.LoginScreen
import com.example.shark.screen.ProductScreen
import com.example.shark.screen.ProductScreen_fries
import com.example.shark.screen.RegistrationScreen
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Landing.route) {
        composable(route = Screen.Landing.route) {
            LandingScreen(navController = navController)
        }
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }

        composable(
            route = Screen.Product.route + "/{productType}",
            arguments = listOf(navArgument("productType") { type = NavType.StringType })
        ) { backStackEntry ->
            val productType = backStackEntry.arguments?.getString("productType")
            when (productType) {
                ProductType.ChineseBowl.route -> ProductScreen(navController = navController)
                ProductType.PeriPeriFries.route -> ProductScreen_fries(navController = navController)
                ProductType.DosaCombo.route -> ProductScreen_dosa(navController = navController)
                ProductType.VegBurger.route -> ProductScreen_Burger(navController = navController)
                ProductType.HakkaNoodles.route -> ProductScreen_Noodles(navController = navController)
                ProductType.PremiumThali.route -> ProductScreen_PremiumThali(navController = navController)
                ProductType.PotatoSamosa.route -> ProductScreen_Samosa(navController = navController)
                ProductType.SpringRoll.route -> ProductScreen_SpringRoll(navController = navController)
                ProductType.Thali.route -> ProductScreen_Thali(navController = navController)
                ProductType.ThukpaSoup.route -> ProductScreen_Thukpa(navController = navController)
                else -> NoProductScreen()
            }
        }
        composable(route = Screen.Account.route) {
            AccountScreen(navController = navController)
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
    }
}
