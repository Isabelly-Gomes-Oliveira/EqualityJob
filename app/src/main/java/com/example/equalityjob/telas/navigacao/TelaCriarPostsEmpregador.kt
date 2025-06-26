package com.example.equalityjob.telas.navigacao

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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.equalityjob.data.model.VagaEmprego
import com.example.equalityjob.viewmodel.VagaEmpregoViewModel

@Composable
fun TelaCriarPostsEmpregador(vagaEmpregoViewModel: VagaEmpregoViewModel = viewModel()) {
    // variáveis para os dados digitados
    var titulo by remember { mutableStateOf("") }
    var descricaoVaga by remember { mutableStateOf("") }
    var cargo by remember { mutableStateOf("") }
    var salario by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }

    val opcoesModalidade = listOf("Presencial", "Remoto", "Híbrido (ambos)")
    var modalidadesMarcadas = remember { mutableStateListOf(false, false, false) }

    val opcoesFaixasEtarias = listOf("Jovem aprendiz", "Adulto", "Outro")
    var faixasEtariasMarcadas = remember { mutableStateListOf(false, false, false) }

    val opcoesNecessidadeEspecial =
        listOf("Deficiência auditiva", "Deficiência visual", "Deficiência física", "Outro: ")
    var necessidadesEspeciaisMarcadas = remember { mutableStateListOf(false, false, false, false) }

    val opcoesCausas = listOf("LGBTQIA+", "Diversidade Etnica", "Todas", "Outra(s)")
    var causasMarcadas = remember { mutableStateListOf(false, false, false, false) }

    val opcoesExperiencia = listOf("Sim", "Não", "Indiferente")
    var experienciaSelecionada by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(top = 25.dp)
            .verticalScroll(rememberScrollState()) // permite a rolagem da tela
    ) {
        Text(
            "Divulgar vaga de emprego",
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
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Título*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Descrição da vaga*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = descricaoVaga,
                onValueChange = { descricaoVaga = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Cargo*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = cargo,
                onValueChange = { cargo = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Salário*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = salario,
                onValueChange = { salario = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Endereço*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = endereco,
                onValueChange = { endereco = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Modalidade*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //opções
            opcoesModalidade.forEach { opcao ->
                var indice = 0
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(30.dp)
                ) {
                    Checkbox(
                        checked = modalidadesMarcadas[indice],
                        onCheckedChange = { modalidadesMarcadas[indice] = it }
                    )

                    Text(
                        text = opcao,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                indice++
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Faixas etárias*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //opções
            opcoesFaixasEtarias.forEach { opcao ->
                var indice = 0
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(30.dp)
                ) {
                    Checkbox(
                        checked = faixasEtariasMarcadas[indice],
                        onCheckedChange = { faixasEtariasMarcadas[indice] = it }
                    )

                    Text(
                        text = opcao,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                indice++
            }

            Text(
                text = "A vaga abrange para pessoas com alguma necessidade especial? Se sim, qual(is)?",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //opções
            opcoesNecessidadeEspecial.forEach { opcao ->
                var indice = 0
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(30.dp)
                ) {
                    Checkbox(
                        checked = necessidadesEspeciaisMarcadas[indice],
                        onCheckedChange = { necessidadesEspeciaisMarcadas[indice] = it }
                    )

                    Text(
                        text = opcao,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                indice++
            }

            Text(
                text = "Causas apoiadas pela empresa:",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //opções
            opcoesCausas.forEach { opcao ->
                var indice = 0
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(30.dp)
                ) {
                    Checkbox(
                        checked = causasMarcadas[indice],
                        onCheckedChange = { causasMarcadas[indice] = it }
                    )

                    Text(
                        text = opcao,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                indice++
            }

            Text(
                text = "É necessário ter experiência no mercado de trabalho?*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //opções
            opcoesExperiencia.forEach { opcao ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(35.dp)
                ) {
                    RadioButton(
                        selected = (opcao == experienciaSelecionada),
                        onClick = { experienciaSelecionada = opcao }
                    )
                }
                Text(        // o texto de cada opção
                    text = opcao,
                    fontSize = 20.sp
                )
            }


            Text(
                text = "Adicionar imagens:*",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //botão com ícone de imagem
            //. . .

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    vagaEmpregoViewModel.adicionarVagaEmprego(
                        VagaEmprego(
                            0,
                            titulo,
                            descricaoVaga,
                            cargo,
                            salario.toDouble(),
                            endereco,
                            opcoesModalidade.filterIndexed { index, _ -> modalidadesMarcadas[index] },
                            opcoesFaixasEtarias.filterIndexed { index, _ -> faixasEtariasMarcadas[index] },
                            necessidadesEspeciaisMarcadas.any { it },
                            opcoesNecessidadeEspecial.filterIndexed { index, _ -> necessidadesEspeciaisMarcadas[index] },
                            opcoesCausas.filterIndexed { index, _ -> causasMarcadas[index] },
                            experienciaSelecionada,
                            emptyList()
                        )
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Centraliza horizontalmente
                    .width(280.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(0.dp), // bordas do botão retas
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3676B7)) // Cor de fundo do botão

            ) {
                Text(
                    text = "Publicar",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaCriarPostsEmpregadorPreview() {
    TelaCriarPostsEmpregador()
}