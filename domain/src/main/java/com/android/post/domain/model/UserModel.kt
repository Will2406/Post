package com.android.post.domain.model

import com.android.post.data.model.UserResponse

data class UserModel(
    val id: Int,
    val name: String,
    val country: String,
    val email: String,
    var listPost: MutableList<PostModel> = mutableListOf()
)


fun UserResponse.convertToModel() = UserModel(
    id = id,
    name = name,
    country = "${address.street}, ${address.city}",
    email = email,
    listPost = mutableListOf()
)

fun List<UserResponse>.convertToModel() = map(UserResponse::convertToModel)