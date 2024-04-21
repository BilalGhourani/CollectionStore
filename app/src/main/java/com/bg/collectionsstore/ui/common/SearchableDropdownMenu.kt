package com.bg.collectionsstore.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.bg.collectionsstore.data.DataModel
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.utils.Utils


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchableDropdownMenu(
    modifier: Modifier = Modifier,
    items: MutableList<DataModel> = mutableListOf(),
    selectedItem: String = "",
    onSelectionChange: (DataModel) -> Unit = {},
) {
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf(selectedItem) }
    var filteredItems by remember { mutableStateOf(items) }
    LaunchedEffect(searchText) {
        filteredItems =
            items.filter { it.getName().contains(searchText, ignoreCase = true) }.toMutableList()
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                modifier = modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                label = { Text("Select User") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                }
            )

            if (filteredItems.isNotEmpty()) {
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = modifier
                        .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                ) {
                    filteredItems.forEach { item ->
                        val text = item.getName()
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                onSelectionChange(item)
                                searchText = text
                                expanded = false
                            })
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchableDropdownMenuPreview() {
    CollectionsStoreTheme {
        SearchableDropdownMenu(
            items = Utils.users
        )
    }
}
