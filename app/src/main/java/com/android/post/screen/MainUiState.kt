package com.android.post.screen

import com.android.post.domain.model.UserModel

data class MainUiState(
    var loadingUser: Boolean = false,
    var userList: MutableList<UserModel> = mutableListOf(),
)