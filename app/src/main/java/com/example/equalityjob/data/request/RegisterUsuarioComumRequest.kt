package com.example.equalityjob.data.request

import java.util.Date

data class RegisterUsuarioComumRequest(
    val idUsuario: Int,
    val estado: String,
    val cidade: String,
    val bairro: String,
    val rua: String,
    val dataNascimento: Date,
    val etnia: String?,
    val identidadeGenero: String?,
    val sexualidade: String?,
    val formacao: String?,
    val possuiExperiencia: Boolean?,
    val condicoesEspeciais: List<String>,
    val email: String?,
    val resumoProfissional: String?
)
