package com.example.equalityjob

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@Composable
fun telaFormularioUsuarioComum(){
// variáveis para as informações do formulário
    var estado by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var rua by remember { mutableStateOf("") }

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var dataNascimento by remember { mutableStateOf(LocalDate.of(2000, 1, 1)) }

    //opções de formação
    val opcoesFormacao = listOf("Fundamental incompleto", "Fundamental completo", "Ensino médio incompleto", "Ensino médio completo", "Ensino superior")
    var formacaoSelecionada by remember { mutableStateOf("") }

    //Opções de etnia
    val opcoesEtnia = listOf("Preto", "Pardo", "Branco", "Amarelo", "Indígena", "Outro")
    var etniaSelecionada by remember { mutableStateOf("") }

    //opções de possui experiência
    val opcoesExperiencia = listOf("Sim", "Não")
    var experienciaSelecionada by remember { mutableStateOf("") }

    //opções de identidade de gênero
    val opcoesGenero = listOf("Homem", "Mulher", "Não-binário", "Agênero", "Gênero fluido", "Outro")
    var generoSelecionado by remember { mutableStateOf("") }

    //opções de sexualidade
    val opcoesSexualidade = listOf("Heterossexual", "Homossexual", "Bissexual", "Assexual", "Pansexual", "Outro")
    var sexualidadeSelecionada by remember { mutableStateOf("") }


    var email by remember { mutableStateOf("") }
    var resumo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(top = 25.dp)
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ){
        Text("Formulário - Usuário Comum",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold, // Deixa o texto em negrito
            modifier = Modifier.padding(start = 20.dp) // Padding à esquerda
        )

        Spacer(modifier = Modifier.height(15.dp))

        Divider( // para adicionar uma linha horizontal
            thickness = 1.5.dp,                          // espessura da linha
            color = Color(0xFFAFAFAF),            // cor da linha
        )


        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
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
                modifier = Modifier.fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Data de nascimento*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = dataNascimento.format(formatter),  // converte LocalDate para String
                onValueChange = { newValue ->             // tenta converter de volta a String para LocalDate
                    try {
                        dataNascimento = LocalDate.parse(newValue, formatter)
                    } catch (e: Exception) {
                        // Em caso de erro, você pode tratar de alguma forma, como deixar a data anterior
                    }
                },
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Formação",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //opções

            Row(){
                Column(
                    Modifier
                        .width(160.dp)
                ){
                    Text(
                        text = "Etnia",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    //opções
                }

                Spacer(Modifier.width(15.dp))

                Column(){
                    Text(
                        text = "Possui experiência?",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    //opções
                }

            }

            Row(){
                Column(){
                    Text(
                        text = "Sexualidade",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                Column(){
                    Text(
                        text = "Identidade de gênero",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }



            Text(text = "Condição especial")
            //opções

            Text(
                text = "Email",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Resumo sobre sua vida profissional",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = resumo,
                onValueChange = { resumo = it },
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

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
                    text = "Cadastrar",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TelaFormularioUsuarioComum(){
    telaFormularioUsuarioComum()
}