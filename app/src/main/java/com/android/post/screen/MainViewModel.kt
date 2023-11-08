package com.android.post.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.post.domain.usecase.GetAllUsersUseCase
import com.android.post.domain.usecase.GetPostsByUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUsers: GetAllUsersUseCase,
    private val getPostsByUser: GetPostsByUserUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(MainUiState())
    val viewState: StateFlow<MainUiState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.update { it.copy(loadingUser = true) }
            getAllUsers.invoke()
                .collect { userList ->
                    userList.forEach { user ->
                        getPostsByUser.invoke(user.id)
                            .collect {
                                user.listPost = it.toMutableList()
                            }
                        delay(1500)
                        _viewState.update { it.copy(userList = userList.toMutableList(), loadingUser = false) }
                    }

                }
        }
    }

}