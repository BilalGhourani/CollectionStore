package com.bg.collectionsstore.ui.Item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.utils.Utils

@Composable
fun ItemListCell(
    items: MutableList<Item>,
    onClick: (Item) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        columns = GridCells.Adaptive(120.dp)
    ) {
        items.forEachIndexed { index, item ->
            item {
                ItemCell(
                    item = item,
                    Modifier
                        .clickable {
                            onClick(item)
                        },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListCellPreview() {
    CollectionsStoreTheme {
        ItemListCell(
            Utils.listOfItems
        )
    }
}