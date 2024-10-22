package com.example.jetpack_compose_app_transaction.presentation.abount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_app_transaction.R

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Text(text = "xPense",color= Color(0xFF5F7464), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "With love", fontStyle = FontStyle.Italic)
        Text(text = "from", fontStyle = FontStyle.Italic)
        Text(text = "Nguyen Anh Ky", fontSize = 24.sp)
    }

}

@Preview
@Composable
private fun AboutScreenPreview() {
    AboutScreen()
}