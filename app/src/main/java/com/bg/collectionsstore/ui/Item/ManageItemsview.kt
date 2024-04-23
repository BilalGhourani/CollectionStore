package com.bg.collectionsstore.ui.Item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.utils.Utils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageItemsView(
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
                                text = "Manage Items",
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