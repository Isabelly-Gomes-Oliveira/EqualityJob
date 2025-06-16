package com.example.equalityjob.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.equalityjob.data.model.Empregador
import com.example.equalityjob.data.request.RegisterEmpregadorRequest
import com.example.equalityjob.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmpregadorViewModel : ViewModel() {
    val empregadores = mutableStateOf<List<Empregador>>(emptyList())
    val empregadorDetalhe = mutableStateOf<Empregador?>(null)

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    fun listarEmpregadores() {
        coroutineScope.launch {
            empregadores.value = RetrofitClient.instance.listarEmpregadores(RetrofitClient.buildAuthHeader())
        }
    }

    fun buscarEmpregadorPorId(id: Int) {
        coroutineScope.launch {
            empregadorDetalhe.value = RetrofitClient.instance.empregadorPorId(id, RetrofitClient.buildAuthHeader())
        }
    }

    fun cadastrarEmpregador(empregador: RegisterEmpregadorRequest) {
        coroutineScope.launch {
            val empregadorCriado = RetrofitClient.instance.registrarEmpregador(empregador)
            empregadores.value += empregadorCriado
        }
    }
}