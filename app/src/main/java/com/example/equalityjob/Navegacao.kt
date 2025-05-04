package com.example.equalityjob

import androidx.compose.foundation.background

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun telaNavegacao(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(0xFF041438))
            .padding(30.dp)
    ){
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "EQualityJob", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "x", fontSize = 30.sp, fontWeight = FontWeight.Bold , color = Color.White)
        }
    }

    Spacer(Modifier.height(40.dp))

    Column(
        Modifier
            .padding(50.dp)
            .fillMaxWidth()
    ){
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text= "Home",
                fontSize = 26.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text= "Oportunidades",
                fontSize = 26.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text= "Comunidade",
                fontSize = 26.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text= "Perfil",
                fontSize = 26.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text= "Contato",
                fontSize = 26.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaNavegacao(){
   telaNavegacao()
}