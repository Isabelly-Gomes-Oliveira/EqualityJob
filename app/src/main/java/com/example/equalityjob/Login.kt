package com.example.equalityjob

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@Composable
fun telaLogin(){
    // Para armazenar as informações que serão digitadas
    var cpf by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var aceitaTermos by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .fillMaxSize()
        .padding(top = 40.dp, bottom = 16.dp)
    ){
        Text("Login",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold, // Deixa o texto em negrito
            modifier = Modifier.padding(start = 20.dp) // Padding à esquerda
        )

        Spacer(modifier = Modifier.height(15.dp))

        Divider( // para adicionar uma linha horizontal
            thickness = 1.5.dp,                          // espessura da linha
            color = Color(0xFFAFAFAF),            // cor da linha
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .padding(16.dp)
        ){
            // Campo do CPF
            Text(text = "CPF*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = cpf,
                onValueChange = { cpf = it },
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Campo da senha
            Text(text = "Senha (6 dígitos)*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))

            // campo de aceitar o termo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Checkbox(
                    checked = aceitaTermos,
                    onCheckedChange = { aceitaTermos = it }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Autorizo a coleta dos meus dados e estou ciente que entrarão em contato comigo pelos canais de comunicação aqui estipulados, assim como estou integralmente de acordo com a Política de Privacidade deste website.",
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            //Campo do botão
            Button(
                onClick = {
                    // lidando com o click do botão
                    // . . .
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Centraliza horizontalmente
                    .width(280.dp)
                    .height(55.dp)
                ,
                shape = RoundedCornerShape(0.dp), // bordas do botão retas
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)) // Cor de fundo do botão

            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }

        }


    }

}

@Preview(showBackground = true)
@Composable
fun TelaLoginPreview(){
    telaLogin()
}