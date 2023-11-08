package com.android.post.domain.model

import com.android.post.data.model.PostResponse

data class PostModel(val id: Int, val title: String, val description: String)

fun PostResponse.convertToModel() = PostModel(
    id = id,
    title = title,
    description = body
)

fun List<PostResponse>.convertToModel() = map(PostResponse::convertToModel)