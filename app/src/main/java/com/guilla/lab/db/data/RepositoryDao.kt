package com.guilla.lab.db.data

import android.arch.persistence.room.*

import com.guilla.lab.Model.Repository

/*
 *  Room RepositoryDao : functions to insert, fetch, and delete books.
 * */

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(repository: Repository)

    @Query("SELECT * FROM repository")
    fun fetchListBooks(): List<Repository>

    @Query("DELETE FROM repository")
    fun clearBooktable()
}