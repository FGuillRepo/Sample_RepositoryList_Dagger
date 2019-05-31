package com.guilla.lab.db.data

import com.guilla.lab.Model.Repository

import javax.inject.Inject

class ProductDataSource @Inject
constructor(private val productDao: RepositoryDao) {


    fun repositoryList(): List<Repository> {
        return productDao.fetchListBooks()
    }
}