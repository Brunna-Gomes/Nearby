package com.rocketseat.nlw.nearby.ui.theme.component.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rocketseat.nlw.nearby.data.model.Market
import com.rocketseat.nlw.nearby.ui.theme.NearbyTheme
import com.rocketseat.nlw.nearby.ui.theme.screen.HomeScreen
import com.rocketseat.nlw.nearby.ui.theme.screen.MarketDetailsScreen
import com.rocketseat.nlw.nearby.ui.theme.screen.SplashScreen
import com.rocketseat.nlw.nearby.ui.theme.screen.WelcomeScreen
import com.rocketseat.nlw.nearby.ui.theme.screen.route.Home
import com.rocketseat.nlw.nearby.ui.theme.screen.route.Splash
import com.rocketseat.nlw.nearby.ui.theme.screen.route.Welcome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(onNavigateToMarketDetails = { selectedMarket ->
                            navController.navigate(selectedMarket)
                        })

                    }
                    composable<Market>{
                        val selectedMarket = it.toRoute<Market>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
