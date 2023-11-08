package com.android.post.data.datasource.post

import com.android.post.data.model.PostResponse
import kotlinx.coroutines.flow.Flow


interface PostRemoteDataSource {
    suspend fun getPostByUser(idUser: Int): Flow<List<PostResponse>>
}

interface PostLocalDataSource {}

