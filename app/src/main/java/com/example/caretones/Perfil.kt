package com.example.caretones

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caretones.RoomDB.Pessoa
import com.example.caretones.ui.theme.Branco
import com.example.caretones.ui.theme.CareTonesTheme
import com.example.caretones.ui.theme.Turquoise
import com.example.caretones.viewModel.PessoaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(navController: NavController, viewModel: PessoaViewModel, modifier: Modifier = Modifier, mainActivity: MainActivity) {
    var pessoaList by remember {
        mutableStateOf(listOf<Pessoa>())
    }
    var pessoa by remember {
        mutableStateOf(
            Pessoa(
                email = "",
                senha = "",
                nome = "",
                datansc = "",
                cpf = "",
                telefone = "",
                endereco = "",
                logado = false
            )
        )
    }
    val shouldShowDialog = remember { mutableStateOf(false) } // 1
    LaunchedEffect(
        key1 = true
    ) {
        CoroutineScope(Main).launch {
            pessoaList = viewModel.testarLogin()
            pessoa = pessoaList[0]
        }
    }

    CareTonesTheme(darkTheme = false, dynamicColor = false) {
        val layoutDirection = LocalLayoutDirection.current

        Scaffold {
            Column(
                Modifier
                    .fillMaxWidth() // Adquirir o tamanho máximo da tela
                    .background(Branco)
            ) {
                // Primeira linha (navbar)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(Turquoise)
                        .padding(7.dp),
                    verticalAlignment = Alignment.CenterVertically // Alinhamento vertical central
                ) {
                    // Adição de imagem (ícone)
                    val imagem1 =
                        painterResource(R.drawable.logo_caretones) // Variável que armazena o recurso da imagem
                    Image(
                        painter = imagem1,
                        contentDescription = null, // Descrição de conteúdo para acessibilidade
                        contentScale = ContentScale.Crop,
                        alpha = 1.0f, // Valor de alpha válido entre 0 (transparente) e 1 (opaco)
                        modifier = Modifier.size(60.dp)
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    // Texto de escolha de nacionalidade
                    Text(
                        text = "Care Tones",
                        modifier = Modifier.offset(y = 3.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.width(75.dp))

                    Button(
                        onClick = {
                            navController.navigate(rotas.Agenda)
                        },
                        colors = ButtonDefaults.buttonColors(Color(24, 103, 108))
                    ) {
                        Text(
                            text = "Voltar",
                            modifier = Modifier.offset(y = 3.dp),
                            style = TextStyle(
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        val imagem2 =
                            painterResource(R.drawable.setavoltar) // Variável que armazena o recurso da imagem
                        Image(
                            painter = imagem2,
                            contentDescription = null, // Descrição de conteúdo para acessibilidade
                            contentScale = ContentScale.Crop,
                            alpha = 1.0f, // Valor de alpha válido entre 0 (transparente) e 1 (opaco)
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                it.calculateTopPadding()
                Column(
                    modifier = Modifier
                        .padding(0.dp, 120.dp, 0.dp, 0.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Informações de Usuario",
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            color = colorResource(R.color.rosa),
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Bold
                            )
                        )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp, 20.dp, 30.dp, 0.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                    ) {

                        Column(
                            Modifier
                            .padding(0.dp,20.dp, 0.dp, 0.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            Text(
                                text = "Nome de Usuario: ".plus(pessoa.nome),
                                style = TextStyle(
                                    color = colorResource(R.color.DarkGrey),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Email: ".plus(pessoa.email),
                                style = TextStyle(
                                    color = colorResource(R.color.DarkGrey),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Nascimento: ".plus(pessoa.datansc),
                                style = TextStyle(
                                    color = colorResource(R.color.DarkGrey),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "CPF: ".plus(pessoa.cpf),
                                style = TextStyle(
                                    color = colorResource(R.color.DarkGrey),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Endereço: ".plus(pessoa.endereco),
                                style = TextStyle(
                                    color = colorResource(R.color.DarkGrey),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Telefone: ".plus(pessoa.telefone),
                                style = TextStyle(
                                    color = colorResource(R.color.DarkGrey),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                        }
                        Row() {
                            Button(
                                onClick = {
                                    pessoa.logado = false
                                    viewModel.upsertPessoa(pessoa)
                                    Toast.makeText(
                                        mainActivity,
                                        "Saindo de " + pessoa.nome + "...",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    navController.navigate(rotas.Inicio)
                                },
                                modifier = Modifier
                                    .height(height = 38.dp)
                                    .padding(15.dp,0.dp,0.dp,0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.Torquoise),
                                ),
                            ) {
                                Text(
                                    text = "Sair da conta",
                                )
                            }
                            Button(
                                onClick = {
                                    pessoa.logado = true
                                    viewModel.upsertPessoa(pessoa)
                                    Toast.makeText(
                                        mainActivity,
                                        "Editando Perfil de " + pessoa.nome + "...",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    navController.navigate(rotas.Edicao)
                                },
                                modifier = Modifier
                                    .padding(25.dp,0.dp,0.dp,0.dp)
                                    .size(95.dp,38.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.Torquoise),
                                ),
                            ) {
                                Text(
                                    text = "Editar",
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
