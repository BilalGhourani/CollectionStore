package com.bg.collectionsstore.ui.pos

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagePosView(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    CollectionsStoreTheme {
        Scaffold(
            topBar = {
                Surface(shadowElevation = 3.dp, color = Color.White) {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(onClick = { navController?.navigateUp() }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        title = {
                            Text(
                                text = "Manage POS",
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        })
                }
            }
        ) {
            Text(
                text = "Coming Soon",
                color = Color.Black,
                modifier = Modifier
                    .padding(it),
                textAlign = TextAlign.Center
            )
        }
    }
}