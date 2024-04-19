package com.bg.collectionsstore.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bg.collectionsstore.data.Category.Category
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.utils.Utils


@Composable
fun CategoryListCell(
    categories: MutableList<Category>,
    onClick: (Category) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectionState by remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectionState, // Set the currently selected tab
        modifier = modifier
            .padding(vertical = 5.dp),
        divider = { null },
        edgePadding = 0.dp,
        contentColor = Color.Black, // Color for tab items (text/icons)
        indicator = {
            null
        }
    ) {
        categories.forEachIndexed { index, category ->
            CategoryCell(
                category = category,
                selected = selectionState == index,
                Modifier
                    .clickable {
                        selectionState = index
                        onClick(category)
                    },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListCellPreview() {
    CollectionsStoreTheme {
        CategoryListCell(
            categories = Utils.categories,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        )
    }
}