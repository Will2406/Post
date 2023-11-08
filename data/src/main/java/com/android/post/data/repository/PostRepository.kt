package com.android.post.data.repository

import com.android.post.data.datasource.post.PostLocalDataSource
import com.android.post.data.datasource.post.PostRemoteDataSource
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remote: PostRemoteDataSource,
    private val local: PostLocalDataSource
) {

    suspend fun getPostByUser(id: Int) = remote.getPostByUser(idUser = id)

}