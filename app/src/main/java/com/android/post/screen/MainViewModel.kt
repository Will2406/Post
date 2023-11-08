package com.android.post.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.post.domain.usecase.GetAllUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUsers: GetAllUsersUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(MainUiState())
    val viewState: StateFlow<MainUiState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllUsers.invoke()
                .collect { userList ->
                    _viewState.update { it.copy(userList = userList) }
                }
        }

    }
}