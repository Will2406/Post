package com.android.post.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.post.ShimmerEffect

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
        state.loadingUser -> UserSectionShimmer()
        else -> {
            if (state.userList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    state.userList.forEach { user ->
                        item {
                            UserItem(user)
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun UserSectionShimmer() {
    ShimmerEffect { brush ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            item {
                for (i in 1..14) {
                    UserItemLoader(brush = brush)
                }
            }
        }
    }
}


@Preview
@Composable
fun UserScreenPreview() {

}