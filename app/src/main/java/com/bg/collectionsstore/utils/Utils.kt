package com.bg.collectionsstore.utils

import androidx.compose.ui.unit.Dp
import com.bg.collectionsstore.data.DataModel
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.model.HomeSectionModel
import java.util.UUID

object Utils {

    val homeSections = mutableListOf(
        HomeSectionModel("Company", ""),
        HomeSectionModel("User", "ManageUsersView"),
        HomeSectionModel("Third Party", ""),
        HomeSectionModel("Item", ""),
        HomeSectionModel("POS", ""),
        HomeSectionModel("Table", ""),
    )

    val users = mutableListOf(
        User(userId = "1", userName = "Bilal", userPassword = "123456") as DataModel,
        User(userId = "1", userName = "Ziad", userPassword = "133442") as DataModel,
        User(userId = "1", userName = "Zakariya", userPassword = "123432") as DataModel,
        User(userId = "1", userName = "Mohammad", userPassword = "432785") as DataModel,
        User(userId = "1", userName = "Ahmad", userPassword = "009988") as DataModel,
        User(userId = "1", userName = "Samir", userPassword = "225577") as DataModel,
        User(userId = "1", userName = "Omar", userPassword = "113311") as DataModel,
        User(userId = "1", userName = "Abed Al Rahman", userPassword = "112345") as DataModel,
        User(userId = "1", userName = "Abdullah", userPassword = "998888") as DataModel,
    )

    val categories = mutableListOf(
        Family("1", "Chicken"),
        Family("2", "Meat"),
        Family("3", "Salad"),
        Family("4", "Veg"),
        Family("5", "Other")
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

    fun generateRandomUuidString(): String {
        return UUID.randomUUID().toString()
    }
}