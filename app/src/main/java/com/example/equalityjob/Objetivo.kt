package com.example.equalityjob

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun telaObjetivo() {

    val opcoes = listOf("Conseguir emprego", "Contratar funcionários") // opções disponíveis para o usuário escolher
    var selecionado by remember { mutableStateOf("") }           // vai guardar a opção escolhida

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(0xFF041438))
            .padding(50.dp)

    ) {
        Text(
            text = "Qual o seu objetivo? ",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold, // texto em negrito
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // alinha o texto hirizontalmente
                .padding(top = 150.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))

        opcoes.forEach { opcao ->
            Row(
                modifier = Modifier
                    .width(290.dp)
                    .height(80.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(10.dp) //cantos arredondados
                    )
                    .clip(RoundedCornerShape(12.dp)) // molda a borda, não deixando que o fundoda row "vaze" para fora das bordas
                    .background(Color.White)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (opcao == selecionado),
                    onClick = { selecionado = opcao }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = opcao,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(40.dp)) // espaço entre as Rows
        }

        Spacer(modifier = Modifier.height(40.dp))  // espaço entre a última Row e o botão

        Button(
            onClick = {
                // evento click do botão
                // . . .
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centraliza horizontalmente
                .width(280.dp)
                .height(55.dp)
            ,
            shape = RoundedCornerShape(0.dp), // bordas do botão retas
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)) // Cor de fundo do botão

        ){
            Text (
                text = "Avançar",
                fontSize = 25.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaObjetivoPreview(){
    telaObjetivo()
}