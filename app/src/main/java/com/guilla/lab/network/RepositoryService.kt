package com.guilla.lab.network

import com.guilla.lab.Model.Repository
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Headers
import retrofit.http.Path

/**
 * Created by ivan on 09/06/14.
 */
interface RepositoryService {

  /*  @GET("/api/v1/pokedex/1")
    fun getPokedex(callback: Callback<Pokedex>)*/

    @Headers("Accept: application/json; charset=utf-8", "Accept-Language: en")
    @GET("/users/google/repos?per_page=20&page=1")
    fun getPokedex(callback: Callback<List<Repository>>)

    @GET("/{resource_uri}")
    fun getRepository(@Path(value = "resource_uri", encode = false) resourceUri: String, callback: Callback<Repository>)
}
