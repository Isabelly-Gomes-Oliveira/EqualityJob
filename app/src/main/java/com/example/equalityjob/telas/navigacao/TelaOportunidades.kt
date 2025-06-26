package com.example.equalityjob.telas.navigacao

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.equalityjob.viewmodel.VagaEmpregoViewModel

@Composable
fun TelaOportunidades(vagasEmpregoViewModel: VagaEmpregoViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        vagasEmpregoViewModel.listarVagasEmprego()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color(0xFF041438))
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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

        Column(
            Modifier
                .fillMaxWidth()
                .padding(28.dp)
        ) {
            Text(text = "Oportunidades", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(15.dp))

            HorizontalDivider(
                thickness = 2.5.dp,
                color = Color.Black
            )

            Spacer(Modifier.height(18.dp))

            LazyColumn {
                items(vagasEmpregoViewModel.vagasEmprego.value) { item ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        AsyncImage(
                            model = item.imagens.firstOrNull(),
                            contentDescription = "Imagem da vaga",
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                        )
                        Spacer(Modifier.width(25.dp))
                        Text(text = "Uma nova proposta de emprego!", fontSize = 20.sp)
                    }
                }
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
fun TelaOportunidadesPreview() {
    TelaOportunidades()
}