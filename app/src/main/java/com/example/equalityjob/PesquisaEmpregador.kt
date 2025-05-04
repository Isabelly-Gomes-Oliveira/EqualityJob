package com.example.equalityjob

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip

@Composable
fun telaPesquisaEmpregador(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(top = 25.dp)
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ){

        Button(
            onClick = {
                // lidando com o click do botão
                // . . .
            },
            modifier = Modifier
                .padding(start = 25.dp)
                .align(Alignment.Start) // Centraliza horizontalmente
                .width(120.dp)
                .height(36.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)) // Cor de fundo do botão
        ){
            Text(
                text = "Voltar",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.height(25.dp))

        Divider( // linha horizontal
            thickness = 2.dp,     // espessura da linha
            color = Color.Black,  // cor da linha
        )

        Column(
            Modifier.padding(26.dp)
        ){
            Text(
                text = "Filtros",
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {
                        // click do botão . . .
                    },
                    Modifier
                    .width(160.dp)
                    .height(48.dp)
                    .padding(top = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF97BCDF))

                ){
                    Text(text = "Região", fontSize = 18.sp, color = Color.Black)
                }
                Button(
                    onClick = {
                        // click do botão . . .
                    },
                    Modifier
                        .width(170.dp)
                        .height(48.dp)
                        .padding(top = 10.dp)
                        .padding(start = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF97BCDF))
                ){
                    Text(text = "Idade", fontSize = 18.sp, color = Color.Black)
                }

            }


            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {
                        // click do botão . . .
                    },
                    Modifier
                        .width(160.dp)
                        .height(48.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF97BCDF))

                ){
                    Text(text = "Experiência", fontSize = 18.sp, color = Color.Black)
                }
                Button(
                    onClick = {
                        // click do botão . . .
                    },
                    Modifier
                        .width(170.dp)
                        .height(48.dp)
                        .padding(top = 10.dp)
                        .padding(start = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF97BCDF))
                ){
                    Text(text = "Gênero", fontSize = 18.sp, color = Color.Black)
                }

            }


            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {
                        // click do botão . . .
                    },
                    Modifier
                        .width(340.dp)
                        .height(48.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF97BCDF))
                ){
                    Text(text = "Condições especiais", fontSize = 18.sp, color = Color.Black)
                }

            }

        }

        Divider( // linha horizontal
            thickness = 2.dp,     // espessura da linha
            color = Color.Black,  // cor da linha
        )

        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(Color(0xFFF8FAFF))
                .border(BorderStroke(2.dp, Color(0xFFBEBABA)), shape = RoundedCornerShape(16.dp))
                .padding(20.dp)
        ){
            Row(

            ){
                // aqui vai ficar a foto de perfil
                Text(
                    text = "Nome da Pessoa",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(26.dp))

            Text(
                text = "IDADE: ",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))

            Text(
                text = "FORMAÇÃO: ",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))

            Text(
                text = "POSSUI EXPERIÊNCIA: ",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))

            Text(
                text = "LOCALIZAÇÃO",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))

            Text(
                text = "RESUMO",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))

            Text(
                text = "ADICIONAIS",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))

            Text(
                text = "CONTATO",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "", fontSize = 20.sp)

            Spacer(Modifier.height(24.dp))
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
@Composable()
fun TelaPesquisaEmpregador(){
    telaPesquisaEmpregador()
}