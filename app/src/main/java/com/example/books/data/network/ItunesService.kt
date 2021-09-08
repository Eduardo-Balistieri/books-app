package com.example.books.data.network

import com.example.books.models.BooksResponse
import com.example.books.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesService {
    @GET("search/")
    suspend fun searchForBooks(
        @Query("term") term: String,
        @Query("country") country: String = Constants.API.COUNTRY,
        @Query("media") media: String = Constants.API.MEDIA,
        @Query("limit") limit: Int = Constants.API.LIMIT,
        @Query("explicit") explicit: String = Constants.API.EXPLICIT
    ): Response<BooksResponse>
}
