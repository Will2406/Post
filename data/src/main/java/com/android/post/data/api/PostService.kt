package com.android.post.data.api

import com.android.post.data.model.UserResponse
import com.android.post.data.model.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("users")
    suspend fun getUsers(): Response<List<UserResponse>>

    @GET("users/{id}/posts")
    suspend fun getPostByUser(@Path("id") id: String): Response<List<PostResponse>>

}