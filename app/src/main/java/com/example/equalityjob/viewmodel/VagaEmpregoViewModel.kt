package com.example.equalityjob.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.equalityjob.data.model.Post
import com.example.equalityjob.data.model.VagaEmprego
import com.example.equalityjob.data.request.CreatePostRequest
import com.example.equalityjob.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VagaEmpregoViewModel: ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    val vagasEmprego = mutableStateOf<List<VagaEmprego>>(emptyList())

    fun adicionarVagaEmprego(vagaEmprego: VagaEmprego) {
        coroutineScope.launch {
            RetrofitClient.instance.criarVagaEmprego(
                vagaEmprego,
                RetrofitClient.buildAuthHeader()
            )
        }
    }

    fun listarVagasEmprego() {
        coroutineScope.launch {
            vagasEmprego.value = RetrofitClient.instance.listarVagasEmprego(RetrofitClient.buildAuthHeader())
        }
    }
}