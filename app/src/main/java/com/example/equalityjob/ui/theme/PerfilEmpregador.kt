package com.example.equalityjob.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.zIndex

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import com.example.equalityjob.R

@Composable
fun telaPerfilEmpregador(){
    var textoPesquisado by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ){

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
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    // imagem das barrinhas
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
                    ){
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)),
                            shape = RectangleShape,
                            modifier = Modifier
                                .border(1.dp, Color.Black)
                        ) {
                            Text(
                                text = "Sobre",
                                fontSize = 8.sp
                            )
                        }

                        Spacer(Modifier.width(14.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RectangleShape,
                            modifier = Modifier
                                .border(1.dp, Color.Black)
                        ) {
                            Text(
                                text = "Posts",
                                fontSize = 8.sp,
                                color = Color.Black
                            )
                        }
                    }


                    Spacer(Modifier.height(16.dp))

                    TextField(
                        value = textoPesquisado,
                        onValueChange = { textoPesquisado = it },
                        placeholder = { Text("Buscar funcionário", fontSize = 15.sp) },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Ícone de busca"
                            )
                        },
                        modifier = Modifier
                            .height(35.dp)
                            .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
                            .fillMaxWidth(),

                        singleLine = true,
                        shape = MaterialTheme.shapes.small
                    )


                }
            }
        }

        Spacer(Modifier.height(60.dp))

        Column(
            Modifier.padding(20.dp)
        ){
            Text(
                text = "NOME DA EMPRESA/NEGÓCIO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Divider(
                // linha horizontal
                thickness = 2.dp,     // espessura da linha
                color = Color.Black,  // cor da linha
            )

            Text(
                text = "DESCRIÇÃO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )
            Text(
                text= "Resumo sobre a empresa.",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Divider(
                // linha horizontal
                thickness = 2.dp,     // espessura da linha
                color = Color.Black,  // cor da linha
            )

            Text(
                text = "ÁREA DE ATUAÇÃO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )
            Text(
                text= "Áreas que a empresa trabalha.",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Divider(
                // linha horizontal
                thickness = 2.dp,     // espessura da linha
                color = Color.Black,  // cor da linha
            )

            Text(
                text = "LOCALIZAÇÃO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )
            Text(
                text= "Cidade: " + "\n" + "Estado: ",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Divider(
                // linha horizontal
                thickness = 2.dp,     // espessura da linha
                color = Color.Black,  // cor da linha
            )

            Text(
                text = "CONTATO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )
            Text(
                text= "Celular: "+"\n"+"Telefone: "+"\n"+"E-mail: ",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Divider(
                // linha horizontal
                thickness = 2.dp,     // espessura da linha
                color = Color.Black,  // cor da linha
            )


        }

        Spacer(modifier = Modifier.weight(1f)) // mantém a Row abaixo sempre no final da tela
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .background(Color(0xFF041438))
                .padding(24.dp)
        ){
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
fun TelaPerfilEmpregador(){
    telaPerfilEmpregador()
}
