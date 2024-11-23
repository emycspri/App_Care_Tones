package com.example.caretones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.caretones.RoomDB.PessoaDataBase
import com.example.caretones.ui.theme.CareTonesTheme
import com.example.caretones.viewModel.PessoaViewModel
import com.example.caretones.viewModel.Repository

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            PessoaDataBase::class.java,
            "CareTones.db"
        ).build()
    }

    private val PessoaViewModel by viewModels<PessoaViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return PessoaViewModel(Repository(db)) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CareTonesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = rotas.Inicio, builder = {
                        composable(rotas.Agenda){
                            NavbarAgenda(navController)
                        }
                        composable(rotas.Visualizar){
                            Vizualizar(navController)
                        }
                        composable(rotas.Perfil){
                            Perfil(navController,PessoaViewModel, mainActivity = this@MainActivity )
                        }
                        composable(rotas.Inicio){
                            InicioCareTones(navController)
                        }
                        composable(rotas.Cadastro){
                            Cadastro(navController,PessoaViewModel, mainActivity = this@MainActivity )
                        }
                        composable(rotas.Login){
                            Login(navController,PessoaViewModel, mainActivity = this@MainActivity )
                        }
                        composable(rotas.Edicao){
                            Editar(navController,PessoaViewModel, mainActivity = this@MainActivity )
                        }
                    })
                }
            }
        }
    }
}