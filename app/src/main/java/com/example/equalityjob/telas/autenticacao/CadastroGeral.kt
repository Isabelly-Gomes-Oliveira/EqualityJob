package com.example.equalityjob.telas.autenticacao

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.equalityjob.viewmodel.UsuarioViewModel


@Composable
fun CadastroGeral(viewModelUsuario: UsuarioViewModel = viewModel(), navController: NavController) {
    // Variáveis para armazenar os valores digitados
    var nome by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var aceitaTermos by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 20.dp, bottom = 16.dp)

    ) {
        Text(
            "Cadastre-se",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold, // Deixa o texto em negrito
            modifier = Modifier.padding(start = 16.dp) // Padding à esquerda
        )

        Spacer(modifier = Modifier.height(15.dp))

        HorizontalDivider(
            // para adicionar uma linha horizontal
            thickness = 1.5.dp,                          // espessura da linha
            color = Color(0xFFAFAFAF)            // cor da linha
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Campo do nome
            Text(
                text = "Nome completo*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            // Campo do celular
            Text(
                text = "Celular*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = celular,
                onValueChange = { celular = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Campo do CPF
            Text(
                text = "CPF*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = cpf,
                onValueChange = { cpf = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Campo da senha
            Text(
                text = "Senha (6 dígitos)*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                modifier = Modifier
                    .fillMaxWidth()
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
            Spacer(modifier = Modifier.height(90.dp))

            //Campo do botão
            Button(
                onClick = {
                    if (aceitaTermos) {
                        viewModelUsuario.registrarUsuario(nome, celular, cpf, senha)

                        navController.navigate("selecionar_objetivo/${viewModelUsuario.usuario.value!!.id}")
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Centraliza horizontalmente
                    .width(280.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(0.dp), // bordas do botão retas
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)) // Cor de fundo do botão
            ) {
                Text(
                    text = "Avançar",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }
    }
}

