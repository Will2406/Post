package com.android.post.data.datasource.post

import com.android.post.data.api.PostService
import com.android.post.data.model.PostResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val api: PostService
) : PostRemoteDataSource {

    override suspend fun getPostByUser(idUser: String): Flow<List<PostResponse>> {
        return flow {
            val response = api.getPostByUser(idUser)
            if (response.isSuccessful) {
                emit(response.body() ?: listOf())
            }
        }
    }
}