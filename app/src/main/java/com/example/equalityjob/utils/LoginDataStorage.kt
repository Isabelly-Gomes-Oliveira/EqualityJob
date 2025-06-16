package com.example.equalityjob.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.core.content.edit

object LoginDataStorage {
    private const val SECURE_PREFS_NAME = "secure_prefs"
    private const val KEY_CPF = "cpf"
    private const val KEY_SENHA = "senha"
    private var token: String? = null

    fun getToken(): String? {
        return token
    }

    fun setToken(newToken: String) {
        token = newToken
    }

    private fun getEncryptedSharedPreferences(context: Context) = EncryptedSharedPreferences.create(
        context,
        SECURE_PREFS_NAME,
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveLoginCredentials(context: Context, cpf: String, senha: String) {
        getEncryptedSharedPreferences(context).edit().apply {
            putString(KEY_CPF, cpf)
            putString(KEY_SENHA, senha)
            apply()
        }
    }

    fun getCpf(context: Context): String? {
        return getEncryptedSharedPreferences(context).getString(KEY_CPF, null)
    }

    fun getSenha(context: Context): String? {
        return getEncryptedSharedPreferences(context).getString(KEY_SENHA, null)
    }

    fun clearLoginInfo(context: Context) {
        getEncryptedSharedPreferences(context).edit { clear() }
    }

    fun isUserLoggedIn(context: Context): Boolean {
        return getCpf(context) != null && getSenha(context) != null
    }
}