package com.example.equalityjob.network

import com.example.equalityjob.data.model.Empregador
import com.example.equalityjob.data.model.Post
import com.example.equalityjob.data.model.Usuario
import com.example.equalityjob.data.model.UsuarioComum
import com.example.equalityjob.data.model.VagaEmprego
import com.example.equalityjob.data.request.CreatePostRequest
import com.example.equalityjob.data.request.LoginRequest
import com.example.equalityjob.data.request.RegisterEmpregadorRequest
import com.example.equalityjob.data.request.RegisterUsuarioComumRequest
import com.example.equalityjob.data.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface EQualityJobApi {
    // Autenticação
    @POST("/auth/registar/usuario")
    suspend fun registrarUsuario(@Body dadosUsuario: Usuario): retrofit2.Response<Usuario>

    @POST("/auth/registrar/usuario-comum")
    suspend fun registrarUsuarioComum(@Body dadosUsuarioComum: RegisterUsuarioComumRequest): UsuarioComum

    @POST("/auth/registrar/empregador")
    suspend fun registrarEmpregador(@Body dadosEmpregador: RegisterEmpregadorRequest): Empregador

    @POST("/auth/login")
    suspend fun login(@Body dadosLogin: LoginRequest): retrofit2.Response<LoginResponse>

    // Usuários comum
    @GET("/usuarios")
    suspend fun listarUsuariosComum(@Header("Authorization") authHeader: String): List<UsuarioComum>

    @GET("/usuarios/{id}")
    suspend fun usuarioComumPorId(
        @Path("id") id: Int,
        @Header("Authorization") authHeader: String
    ): retrofit2.Response<UsuarioComum>

    // Empregadores
    @GET("/empregadores")
    suspend fun listarEmpregadores(@Header("Authorization") authHeader: String): List<Empregador>

    @GET("/empregadores/{id}")
    suspend fun empregadorPorId(
        @Path("id") id: Int,
        @Header("Authorization") authHeader: String
    ): Empregador

    // Vagas de emprego
    @GET("/vagas-emprego")
    suspend fun listarVagasEmprego(@Header("Authorization") authHeader: String): List<VagaEmprego>

    @POST("/vagas-emprego")
    suspend fun criarVagaEmprego(
        @Body vaga: VagaEmprego,
        @Header("Authorization") authHeader: String
    ): retrofit2.Response<Unit>

    // Postagens
    @GET("/postagens")
    suspend fun listarPostagens(@Header("Authorization") authHeader: String): List<Post>

    @GET("/postagens/usuario/{idUsuario}")
    suspend fun listarPostagensPorUsuario(
        @Path("idUsuario") idUsuario: Int,
        @Header("Authorization") authHeader: String
    ): List<Post>

    @POST("/postagens")
    suspend fun criarPostagem(
        @Body postagem: CreatePostRequest,
        @Header("Authorization") authHeader: String
    ): retrofit2.Response<Post>
}