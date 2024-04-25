package com.bg.collectionsstore.ui.Item

import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.data.PosPrinter.PosPrinter

data class ManageItemsState(
    val items: MutableList<Item> = mutableListOf(),
    val companies: MutableList<Company> = mutableListOf(),
    val families: MutableList<Family> = mutableListOf(),
    val printers: MutableList<PosPrinter> = mutableListOf(),
    var selectedItem: Item = Item(),
    val isLoading: Boolean = false,
    val warning: String? = null,
)