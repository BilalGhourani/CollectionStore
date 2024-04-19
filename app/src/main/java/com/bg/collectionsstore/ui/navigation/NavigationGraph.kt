package com.bg.collectionsstore.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bg.collectionsstore.ui.home.components.CollectionsView
import com.bg.collectionsstore.ui.home.components.HomeView
import com.bg.collectionsstore.ui.login.LoginView
import com.bg.collectionsstore.ui.theme.White

@Composable
fun AuthNavGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
        .background(color = White)
        .padding(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.background(color = White)
    ) {
        // Collections View
        composable(route = "HomeView") { HomeView(navController) }
        // Collections View
        composable(route = "LoginView") { LoginView(navController) }
        // Collections View
        composable(route = "CollectionsView") { CollectionsView(navController) }
    }
}