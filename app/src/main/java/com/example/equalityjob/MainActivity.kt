package com.example.equalityjob

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.equalityjob.component.NavigationScaffold
import com.example.equalityjob.data.request.LoginRequest
import com.example.equalityjob.network.RetrofitClient
import com.example.equalityjob.telas.autenticacao.CadastroGeral
import com.example.equalityjob.telas.autenticacao.FormularioEmpregador
import com.example.equalityjob.telas.autenticacao.FormularioUsuarioComum
import com.example.equalityjob.telas.autenticacao.Login
import com.example.equalityjob.telas.autenticacao.SelecionarObjetivo
import com.example.equalityjob.telas.navigacao.TelaCriarPostsEmpregador
import com.example.equalityjob.telas.navigacao.TelaOportunidades
import com.example.equalityjob.telas.navigacao.TelaPerfilEmpregador
import com.example.equalityjob.telas.navigacao.TelaPerfilEmpregadorPosts
import com.example.equalityjob.telas.navigacao.TelaPesquisaEmpregador
import com.example.equalityjob.telas.navigacao.TelaPesquisaUsuarioComum
import com.example.equalityjob.telas.navigacao.TelaPrincipal
import com.example.equalityjob.ui.theme.EqualityJobTheme
import com.example.equalityjob.utils.LoginDataStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App(startDestination: String) {
    val navController = rememberNavController()
    EqualityJobTheme {
        NavigationScaffold(navController = navController) {
            NavHost(navController = navController, startDestination = startDestination) {
                composable(route = "criar_post") { TelaCriarPostsEmpregador() }
                composable(route = "oportunidades") { TelaOportunidades() }
                composable(route = "perfil_empregador") { TelaPerfilEmpregador() }
                composable(route = "perfil_empregador_posts") { TelaPerfilEmpregadorPosts() }
                composable(route = "perfil_usuario_comum") { TelaPesquisaUsuarioComum() }
                composable(route = "pesquisa_empregador") { TelaPesquisaEmpregador() }
                composable(route = "pesquisa_usuario_comum") { TelaPesquisaUsuarioComum() }
                composable(route = "home") { TelaPrincipal() }

                composable(route = "cadastro_geral") { CadastroGeral(navController = navController) }
                composable(route = "formulario_empregador/{id}") { navBackStackEntry ->
                    val userId = navBackStackEntry.arguments!!.getInt("id")
                    FormularioEmpregador(userId = userId, navController = navController)
                }
                composable(route = "formulario_usuario_comum/{id}") { navBackStackEntry ->
                    val userId = navBackStackEntry.arguments!!.getInt("id")
                    FormularioUsuarioComum(userId = userId, navController = navController)
                }
                composable(route = "login") { Login(navController = navController) }
                composable(route = "selecionar_objetivo/{id}") { navBackStackEntry ->
                    val userId = navBackStackEntry.arguments!!.getInt("id")
                    SelecionarObjetivo(userId = userId, navController = navController)
                }
            }
        }
    }
}

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (LoginDataStorage.isUserLoggedIn(this)) {
            val cpf = LoginDataStorage.getCpf(this)!!
            val senha = LoginDataStorage.getSenha(this)!!

            CoroutineScope(Dispatchers.Main.immediate).launch {
                val loginResponse = RetrofitClient.instance.login(LoginRequest(cpf, senha))
                if (loginResponse.isSuccessful) {
                    LoginDataStorage.setToken(loginResponse.body()!!.token)
                    setContent {
                        App("home")
                    }
                } else {
                    setContent {
                        App("login")
                    }
                }

            }
        } else {
            setContent {
                App("cadastro_geral")
            }
        }
    }
}
