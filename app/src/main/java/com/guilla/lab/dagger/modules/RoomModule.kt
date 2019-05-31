package com.guilla.lab.dagger.modules

import android.arch.persistence.room.Room

import com.guilla.lab.Application
import com.guilla.lab.db.data.Database
import com.guilla.lab.db.data.ProductDataSource
import com.guilla.lab.db.data.RepositoryDao

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class RoomModule(mApplication: Application) {

    private val demoDatabase: Database

    init {
        demoDatabase = Room.databaseBuilder(mApplication, Database::class.java, "repository-db").build()
    }

    @Singleton
    @Provides
    internal fun providesRoomDatabase(): Database {
        return demoDatabase
    }

    @Singleton
    @Provides
    internal fun providesProductDao(demoDatabase: Database): RepositoryDao {
        return demoDatabase.productDao
    }

    @Singleton
    @Provides
    internal fun Repository(productDao: RepositoryDao): ProductDataSource {
        return ProductDataSource(productDao)
    }

}