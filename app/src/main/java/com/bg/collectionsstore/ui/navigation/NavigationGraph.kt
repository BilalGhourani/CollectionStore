package com.bg.collectionsstore.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bg.collectionsstore.ui.family.ManageFamiliesView
import com.bg.collectionsstore.ui.Item.ManageItemsView
import com.bg.collectionsstore.ui.company.ManageCompaniesView
import com.bg.collectionsstore.ui.currency.ManageCurrenciesView
import com.bg.collectionsstore.ui.user.ManageUsersView
import com.bg.collectionsstore.ui.home.HomeView
import com.bg.collectionsstore.ui.home.components.CollectionsView
import com.bg.collectionsstore.ui.login.LoginView
import com.bg.collectionsstore.ui.pos.ManagePosView
import com.bg.collectionsstore.ui.table.ManageTablesView
import com.bg.collectionsstore.ui.theme.White
import com.bg.collectionsstore.ui.thirdParty.ManageThirdPartiesView

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

        composable(route = "HomeView") { HomeView(navController) }
        composable(route = "LoginView") { LoginView(navController) }
        composable(route = "CollectionsView") { CollectionsView(navController) }
        composable(route = "ManageCurrenciesView") { ManageCurrenciesView(navController) }
        composable(route = "ManageCompaniesView") { ManageCompaniesView(navController) }
        composable(route = "ManageUsersView") { ManageUsersView(navController) }
        composable(route = "ManageFamiliesView") { ManageFamiliesView(navController) }
        composable(route = "ManageThirdPartiesView") { ManageThirdPartiesView(navController) }
        composable(route = "ManageItemsView") { ManageItemsView(navController) }
        composable(route = "ManagePosView") { ManagePosView(navController) }
        composable(route = "ManageTablesView") { ManageTablesView(navController) }
    }
}