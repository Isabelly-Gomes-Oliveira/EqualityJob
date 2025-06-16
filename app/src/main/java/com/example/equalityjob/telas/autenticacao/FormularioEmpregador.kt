package com.example.equalityjob.telas.autenticacao

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.equalityjob.data.request.RegisterEmpregadorRequest
import com.example.equalityjob.viewmodel.EmpregadorViewModel

@Composable
fun FormularioEmpregador(userId: Int, navController: NavController, viewModelEmpregador: EmpregadorViewModel = viewModel()) {
    var nome by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var rua by remember { mutableStateOf("") }
    var resumo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(top = 25.dp)
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ) {
        Text(
            "Formulário - Empregador",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold, // Deixa o texto em negrito
            modifier = Modifier.padding(start = 20.dp) // Padding à esquerda
        )

        Spacer(modifier = Modifier.height(15.dp))

        HorizontalDivider(
            // para adicionar uma linha horizontal
            thickness = 1.5.dp,                          // espessura da linha
            color = Color(0xFFAFAFAF)            // cor da linha
        )


        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "Nome (contratador/ empresa/ negócio)*",
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

            Text(
                text = "Celular da empresa",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = celular,
                onValueChange = { celular = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Área de atuação",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = area,
                onValueChange = { area = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Endereço",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Estado*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = estado,
                onValueChange = { estado = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Cidade*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = cidade,
                onValueChange = { cidade = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Bairro*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = bairro,
                onValueChange = { bairro = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Rua*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = rua,
                onValueChange = { rua = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Resumo sobre sua vida profissional",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = resumo,
                onValueChange = { resumo = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))


            Button(
                onClick = {
                    viewModelEmpregador.cadastrarEmpregador(
                        RegisterEmpregadorRequest(userId, nome, celular, area, email, estado, cidade, bairro, rua, resumo)
                     )

                    navController.navigate("home")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Centraliza horizontalmente
                    .width(280.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(0.dp), // bordas do botão retas
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)) // Cor de fundo do botão

            ) {
                Text(
                    text = "Cadastrar",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }

    }
}
