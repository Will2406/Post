package com.android.post.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.post.R
import com.android.post.domain.model.UserModel

@Composable
fun UserItem(
    user: UserModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
    )

    {
        var expanded by remember { mutableStateOf(false) }

        Column(
            modifier = modifier
                .wrapContentHeight()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {

            HeaderUserItem(user = user, modifier = Modifier) { expanded = it }

            if (expanded) {
                user.listPost.forEach {
                    UserPostItem(title = it.title, description = it.description)
                }

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text("Agregar nuevo post")
                }
            }
        }
    }
}

@Composable
private fun HeaderUserItem(user: UserModel, modifier: Modifier = Modifier, expanded: (Boolean) -> Unit) {

    var expandedState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .height(80.dp)
                .weight(0.5f)
        )

        UserItemDescription(
            name = user.name,
            city = user.country,
            email = user.email,
            modifier = Modifier.weight(1f)
        )

        UserItemButton(
            expanded = expandedState,
            onClick = {
                expandedState = !expandedState
                expanded.invoke(expandedState)
            }
        )

    }
}

@Composable
private fun UserItemDescription(name: String, city: String, email: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Text(
            text = city, fontSize = 12.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = email,
            fontSize = 14.sp,
            maxLines = 1,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 8.dp),
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun UserItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }

}

@Composable
fun UserItemLoader(modifier: Modifier = Modifier, brush: Brush) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
    )

    {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(brush)
                    .clip(RoundedCornerShape(10.dp))
                    .height(80.dp)
                    .padding(start = 16.dp)
                    .weight(0.5f)
            )
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .padding(bottom = 4.dp)
                        .background(brush),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .padding(bottom = 4.dp)
                        .background(brush),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .background(brush),
                )
            }

            UserItemButton(
                expanded = false,
                onClick = {}

            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    MaterialTheme {

    }
}