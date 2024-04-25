package com.bg.collectionsstore.di

import android.app.Application
import androidx.room.Room
import com.bg.collectionsstore.data.AppDatabase
import com.bg.collectionsstore.data.Company.CompanyRepository
import com.bg.collectionsstore.data.Company.CompanyRepositoryImpl
import com.bg.collectionsstore.data.Currency.CurrencyRepository
import com.bg.collectionsstore.data.Currency.CurrencyRepositoryImpl
import com.bg.collectionsstore.data.Family.FamilyRepository
import com.bg.collectionsstore.data.Family.FamilyRepositoryImpl
import com.bg.collectionsstore.data.Item.ItemRepository
import com.bg.collectionsstore.data.Item.ItemRepositoryImpl
import com.bg.collectionsstore.data.ThirdParty.ThirdPartyRepository
import com.bg.collectionsstore.data.ThirdParty.ThirdPartyRepositoryImpl
import com.bg.collectionsstore.data.User.UserRepository
import com.bg.collectionsstore.data.User.UserRepositoryImpl
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
    fun provideFamilyRepository(db: AppDatabase): FamilyRepository {
        return FamilyRepositoryImpl(db.categoryDao)
    }

    @Provides
    @Singleton
    fun provideItemRepository(db: AppDatabase): ItemRepository {
        return ItemRepositoryImpl(db.itemDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: AppDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }

    @Provides
    @Singleton
    fun provideCompanyRepository(db: AppDatabase): CompanyRepository {
        return CompanyRepositoryImpl(db.companyDao)
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(db: AppDatabase): CurrencyRepository {
        return CurrencyRepositoryImpl(db.currencyDao)
    }

    @Provides
    @Singleton
    fun provideThirdPartyRepository(db: AppDatabase): ThirdPartyRepository {
        return ThirdPartyRepositoryImpl(db.thirdPartyDao)
    }


}