package com.android.post.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun InitMainScreen() {

    val mainViewModel: MainViewModel = hiltViewModel()

    MainScreen(
        viewModel = mainViewModel,
        state = mainViewModel.viewState.collectAsState().value
    )
}

@Composable
fun MainScreen(viewModel: MainViewModel, state: MainUiState) {

    when {

    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        state.userList?.forEach {
            item {
                UserItem(it)
            }
        }
    }
}

@Preview
@Composable
fun UserScreenPreview() {

}