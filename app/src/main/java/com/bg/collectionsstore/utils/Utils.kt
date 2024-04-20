package com.bg.collectionsstore.utils

import androidx.compose.ui.unit.Dp
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Item.Item

object Utils {

    val homeSections = mutableListOf(
        "Company",
        "User",
        "Third Party",
        "Item",
        "POS",
        "Table"
    )

    val categories = mutableListOf(
        Family(1,"1", "Chicken"),
        Family(2,"2", "Meat"),
        Family(3,"3", "Salad"),
        Family(4,"4", "Veg"),
        Family(5,"5", "Other")
    )

    val listOfItems = mutableListOf(
        Item(itemId = "1", itemName = "Chicken", itemUnitPrice = 100.0),
        Item(itemId = "2", itemName = "Salad", itemUnitPrice = 100.0),
        Item(itemId = "3", itemName = "Veg", itemUnitPrice = 100.0),
        Item(itemId = "4", itemName = "Other", itemUnitPrice = 100.0),
        Item(itemId = "5", itemName = "Other1", itemUnitPrice = 100.0),
        Item(itemId = "6", itemName = "Other2", itemUnitPrice = 100.0),
        Item(itemId = "7", itemName = "Other3", itemUnitPrice = 100.0),
    )

    fun calculateColumns(cellWidth: Dp, screenWidth: Dp): Int {
        val availableSpace = screenWidth - Dp((2 * 16F))// Account for paddings (adjust as needed)
        return (availableSpace / cellWidth).toInt().coerceAtLeast(1) // Ensure at least 1 column
    }
}