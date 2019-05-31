package com.guilla.lab.db.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.guilla.lab.Model.Repository
import com.guilla.lab.db.data.Database.Companion.VERSION

@Database(entities = [Repository::class], version = VERSION, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract val productDao: RepositoryDao

    companion object {

        internal const val VERSION = 1
    }

}