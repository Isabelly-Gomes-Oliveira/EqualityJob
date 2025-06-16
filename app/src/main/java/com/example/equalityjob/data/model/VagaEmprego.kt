package com.example.equalityjob.data.model

data class VagaEmprego(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val cargo: String,
    val salario: Double,
    val endereco: String,
    val modalidades: List<String>,
    val faixasEtarias: List<String>,
    val aceitaNecessidadeEspecial: Boolean,
    val necessidadesEspeciais: List<String>,
    val causasApoiadas: List<String>,
    val experienciaNecessaria: String,
    val imagens: List<String>
)
