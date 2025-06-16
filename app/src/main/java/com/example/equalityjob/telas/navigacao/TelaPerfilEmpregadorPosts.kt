package com.example.equalityjob.telas.navigacao


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.zIndex

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import com.example.equalityjob.R

@Composable
fun TelaPerfilEmpregadorPosts() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                Modifier
                    .background(Color(0xFF041438))
                    .padding(25.dp)
                    .height(130.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "EQualityJob",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White // deixa o ícone branco
                    )
                }
            }

            Row(
                Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 80.dp) // Desce a Row 80dp
                    .zIndex(1f), // Garante que esta Row fique sobre a anterior
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                // imagem de perfil
                Image(
                    painter = painterResource(id = R.drawable.img_temporaria),
                    contentDescription = "Descrição da imagem",
                    modifier = Modifier
                        .size(200.dp) // define o tamanho da imagem
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop // como a imagem se ajusta ao espaço

                )

                Column(
                    Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp, bottom = 10.dp),

                    verticalArrangement = Arrangement.Bottom
                ) {

                    Spacer(Modifier.height(110.dp))
                    Row(
                        Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RectangleShape,
                            contentPadding = PaddingValues(0.dp),  // para fazer padding valer 0
                            modifier = Modifier
                                .border(1.dp, Color.Black)
                                .background(Color.White)
                                .padding(start = 4.dp, end = 4.dp)
                        ) {
                            Text(
                                text = "Sobre",
                                fontSize = 19.sp,
                                color = Color.Black
                            )
                        }

                        Spacer(Modifier.width(12.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)),
                            shape = RectangleShape,
                            contentPadding = PaddingValues(0.dp),  // para fazer padding valer 0
                            modifier = Modifier
                                .border(1.dp, Color.Black)
                                .background(Color(0xFF3676B7))
                                .padding(start = 4.dp, end = 4.dp)

                        ) {
                            Text(
                                text = "Posts",
                                fontSize = 19.sp,
                                color = Color.White
                            )
                        }
                    }

                }


                Text(
                    text = "Aqui aparecerão os posts feitos pela empresa.",
                    fontSize = 20.sp,
                    color = Color.Black
                )


            }
        }


        Spacer(modifier = Modifier.weight(1f)) // mantém a Row abaixo sempre no final da tela
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .background(Color(0xFF041438))
                .padding(24.dp)
        ) {
            Text(
                text = "@ EQualityJob 2025 todos os direitos reservados",
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaPerfilEmpregadorPostsPreview() {
    TelaPerfilEmpregadorPosts()
}