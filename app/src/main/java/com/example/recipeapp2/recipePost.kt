package com.example.recipeapp2

import com.google.gson.annotations.SerializedName

class recipePost {

    class recipe(
        @SerializedName("author") var author: String?,
        @SerializedName("ingredients") var ingredients: String?,
        @SerializedName("instructions") var instructions: String?,
        @SerializedName("title") var title: String?
    )}