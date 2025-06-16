package com.example.equalityjob.viewmodel

import androidx.lifecycle.ViewModel
import com.example.equalityjob.data.request.RegisterUsuarioComumRequest
import com.example.equalityjob.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioComumViewModel : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    fun registrarUsuarioComum(dadosUsuarioComum: RegisterUsuarioComumRequest) {
        coroutineScope.launch {
            RetrofitClient.instance.registrarUsuarioComum(dadosUsuarioComum)
        }
    }
}