package com.example.equalityjob.data.model

import java.util.Date

data class Post(
    val id: Int,
    val conteudo: String,
    val dataCriacao: Date,
    val criador: Usuario
)
