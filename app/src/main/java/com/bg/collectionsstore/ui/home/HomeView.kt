package com.bg.collectionsstore.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.utils.Utils

@Composable
fun HomeView(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        columns = GridCells.Fixed(3)
    ) {
        Utils.homeSections.forEachIndexed { index, item ->
            item {
                Box( // Use a Box to achieve content alignment
                    modifier = Modifier
                        .width(120.dp)
                        .height(80.dp)
                        .padding(horizontal = 3.dp, vertical = 5.dp)
                        .background(color = Blue, shape = RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center // Center content within the Box
                ) {
                    Text(
                        text = item,
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}