package com.example.recipeapp2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface APIInterface {
    // https://dojo-recipes.herokuapp.com/recipes/
    @Headers("Content-Type: application/json")
    @GET("/recipes/")
    fun getmem(): Call<ArrayList<recipePost.recipe>>
    @Headers("Content-Type: application/json")

    @POST("/recipes/")
    fun addrecpie(@Body userData: recipePost.recipe): Call<recipePost.recipe>
}