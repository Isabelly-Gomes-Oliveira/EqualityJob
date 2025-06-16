package com.example.equalityjob.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.equalityjob.data.model.Usuario
import com.example.equalityjob.data.request.LoginRequest
import com.example.equalityjob.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    val usuario = mutableStateOf<Usuario?>(null)
    val token = mutableStateOf("")
    val loginStatus = mutableStateOf(false)

    fun registrarUsuario(nome: String, celular: String, cpf: String, senha: String) {
        coroutineScope.launch {
            usuario.value = RetrofitClient.instance.registrarUsuario(
                Usuario(
                    id = 0,
                    nome = nome,
                    celular = celular,
                    cpf = cpf,
                    senha = senha
                )
            ).body()
        }
    }

    fun login(cpf: String, senha: String) {
        coroutineScope.launch {
            val response = RetrofitClient.instance.login(LoginRequest(cpf, senha))
            loginStatus.value = response.isSuccessful
            if (response.isSuccessful)
                token.value = response.body()!!.token
        }
    }
}