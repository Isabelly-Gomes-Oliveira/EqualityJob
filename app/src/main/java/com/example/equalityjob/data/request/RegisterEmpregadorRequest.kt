package com.example.equalityjob.data.request

data class RegisterEmpregadorRequest(
    val idUsuario: Int,
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
