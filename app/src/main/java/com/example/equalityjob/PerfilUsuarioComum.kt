package com.example.equalityjob

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun telaPerfilUsuarioComum(){

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ){
        Row(
            Modifier
                .background(Color(0xFF041438))
                .padding(25.dp)
                .height(130.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "EQualityJob", fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.Bold)

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)),
                shape = RoundedCornerShape(8.dp)
            ) {
                // imagem das barrinhas
            }
        }

        Row(){
            // imagem de perfil

            Column(){
                Button(
                    onClick = {}
                ){

                }

                
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TelaPerfilUsuarioComum(){
    telaPerfilUsuarioComum()
}