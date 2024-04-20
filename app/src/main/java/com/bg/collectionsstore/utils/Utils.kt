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
        Family(1, "Chicken"),
        Family(2, "Meat"),
        Family(3, "Salad"),
        Family(4, "Veg"),
        Family(5, "Other")
    )

    val listOfItems = mutableListOf(
        Item(1, "Chicken", "100", "DOLLAR"),
        Item(2, "Meat", "100", "DOLLAR"),
        Item(3, "Salad", "100", "DOLLAR"),
        Item(4, "Veg", "100", "DOLLAR"),
        Item(5, "Other", "100", "DOLLAR"),
        Item(5, "Other1", "100", "DOLLAR"),
        Item(5, "Other2", "100", "DOLLAR"),
        Item(5, "Other3", "100", "DOLLAR"),
    )

    fun calculateColumns(cellWidth: Dp, screenWidth: Dp): Int {
        val availableSpace = screenWidth - Dp((2 * 16F))// Account for paddings (adjust as needed)
        return (availableSpace / cellWidth).toInt().coerceAtLeast(1) // Ensure at least 1 column
    }
}