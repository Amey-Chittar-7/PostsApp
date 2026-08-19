package com.example.postsapp

import com.example.postsapp.model.Comment
import com.example.postsapp.model.PostResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiService {

    //URL: ttps://jsonplaceholder.typicode.com/posts

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

    @POST("posts")
    suspend fun post(@Body post: PostResponse): PostResponse

    @PUT("posts/{id}")
    suspend fun put(
        @Body post: PostResponse,
        @Path("id") userId: Int
    ): PostResponse

    @PATCH("posts/{id}")
    suspend fun patch(
        @Body post: Map<String, String>,
        @Path("id") userId: Int
    ): PostResponse

    @DELETE("posts/{id}")
    suspend fun delete(
        @Path("id") id: Int
    ): Response<Void>

    // https://jsonplaceholder.typicode.com/comments?postId=1
    @GET("comments")
    suspend fun getComments(
        @QueryMap map: Map<String, String>,
    ): List<Comment>

}