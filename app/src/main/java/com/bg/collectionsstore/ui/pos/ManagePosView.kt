package com.bg.collectionsstore.ui.pos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.utils.Utils

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
                                text = "POS",
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        })
                }
            }
        ) {

            if (Utils.isTablet(LocalConfiguration.current)) {
                // Compose your UI for tablets
            } else {
                // Compose your UI for phones or other non-tablet devices
            }
            Surface(
                modifier = modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(horizontal = 10.dp, vertical = 16.dp),
                ) {
                    InvoiceHeaderDetails(
                        navController = navController,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )

                    // Border stroke configuration
                    val borderStroke = BorderStroke(1.dp, Color.Black)

                    InvoiceBodyDetails(
                        navController = navController,
                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f)
                            .border(borderStroke)
                    )

                    InvoiceFooterView(
                        navController = navController,
                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManagePosViewPreview() {
    CollectionsStoreTheme {
        ManagePosView()
    }
}