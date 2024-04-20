package com.bg.collectionsstore.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Family.FamilyDao
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.data.Item.ItemDao
import com.bg.collectionsstore.data.PosPrinter.PosPrinter
import com.bg.collectionsstore.data.PosPrinter.PosPrinterDao
import com.bg.collectionsstore.data.PosReceipt.PosReceipt
import com.bg.collectionsstore.data.PosReceipt.PosReceiptDao
import com.bg.collectionsstore.data.ThirdParty.ThirdParty
import com.bg.collectionsstore.data.ThirdParty.ThirdPartyDao
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.data.User.UserDao

@Database(
    entities = [Family::class, Item::class,
        PosPrinter::class, PosReceipt::class,
        ThirdParty::class, User::class],
    version = 1,
    exportSchema = false
)


abstract class AppDatabase : RoomDatabase() {
    abstract val categoryDao: FamilyDao
    abstract val itemDao: ItemDao
    abstract val posReceiptDao: PosReceiptDao
    abstract val posPrinterDao: PosPrinterDao
    abstract val thirdPartyDao: ThirdPartyDao
    abstract val userDao: UserDao
}