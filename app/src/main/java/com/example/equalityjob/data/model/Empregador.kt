package com.example.equalityjob.data.model

data class Empregador(
    val id: Int,
    val usuario: Usuario,
    val nome: String,
    val celularEmpresa: String,
    val areaAtuacao: String?,
    val email: String?,
    val estado: String,
    val cidade: String,
    val bairro: String,
    val rua: String,
    val resumoEmpresa: String?
)
