package com.bg.collectionsstore.utils

import androidx.compose.ui.unit.Dp
import com.bg.collectionsstore.data.Category.Category
import com.bg.collectionsstore.data.Item.Item

object Utils {

    val categories = mutableListOf(
        Category(1, "Chicken"),
        Category(2, "Meat"),
        Category(3, "Salad"),
        Category(4, "Veg"),
        Category(5, "Other")
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