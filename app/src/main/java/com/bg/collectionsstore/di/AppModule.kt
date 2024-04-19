package com.bg.collectionsstore.di

import android.app.Application
import androidx.room.Room
import com.bg.collectionsstore.data.AppDatabase
import com.bg.collectionsstore.data.Category.CategoryRepository
import com.bg.collectionsstore.data.Category.CategoryRepositoryImpl
import com.bg.collectionsstore.data.Item.ItemRepository
import com.bg.collectionsstore.data.Item.ItemRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGoChatDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "collections_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(db: AppDatabase): CategoryRepository {
        return CategoryRepositoryImpl(db.categoryDao)
    }

    @Provides
    @Singleton
    fun provideItemRepository(db: AppDatabase): ItemRepository {
        return ItemRepositoryImpl(db.itemDao)
    }


}