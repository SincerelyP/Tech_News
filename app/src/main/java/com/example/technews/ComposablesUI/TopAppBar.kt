package com.example.technews.ComposablesUI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.technews.R
import com.example.technews.anton
import com.example.technews.ui.theme.White100

@Composable
fun TopAppBar(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))
            .padding(15.dp)


    ) {
        Text(
            text = "Tech News",
            color = White100,
            fontFamily = anton,
            fontSize = 30.sp,
            letterSpacing = 2.sp
            )
        Icon(
            painter = painterResource(id = R.drawable.bookmark),
            contentDescription ="",
            tint = Color.White,
            modifier = Modifier
                .size(30.dp)
                .clickable { null }
        )


            

    }
}

@Preview
@Composable
fun bar(){
    TopAppBar()
}