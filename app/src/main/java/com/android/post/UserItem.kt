package com.android.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserItem(modifier: Modifier = Modifier) {
    Column {
        UserHeaderItem(modifier = Modifier)
    }
}

@Composable
private fun UserHeaderItem(modifier: Modifier = Modifier) {
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

        DescriptionUserItem(
            name = "Daniel Quispe",
            city = "Lima,Peru",
            email = "william.quispe2497@icloud.com",
            modifier = Modifier.weight(1f)
        )


        Icon(
            imageVector = Icons.Rounded.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.weight(0.3f)
        )

    }
}

@Composable
private fun DescriptionUserItem(name: String, city: String, email: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = city, fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
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


@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    MaterialTheme {
        UserItem()
    }
}