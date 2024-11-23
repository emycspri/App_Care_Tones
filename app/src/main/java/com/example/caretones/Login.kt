package com.example.caretones

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caretones.RoomDB.Pessoa
import com.example.caretones.ui.theme.Branco
import com.example.caretones.ui.theme.CareTonesTheme
import com.example.caretones.ui.theme.Turquoise
import com.example.caretones.ui.theme.Verdin
import com.example.caretones.viewModel.PessoaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, viewModel: PessoaViewModel, modifier: Modifier = Modifier, mainActivity: MainActivity) {
    var email by remember{
        mutableStateOf("")
    }
    var senha by remember{
        mutableStateOf("")
    }
    var pessoaList by remember{
        mutableStateOf(listOf<Pessoa>())
    }

    CareTonesTheme (darkTheme = false, dynamicColor = false) {
        val layoutDirection = LocalLayoutDirection.current
        Scaffold() {
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
                            navController.navigate(rotas.Inicio)
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
                    .fillMaxSize()
                    .padding(30.dp, 75.dp, 30.dp, 40.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Column(
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 25.dp),
                    verticalArrangement = Arrangement.spacedBy(17.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Olá, Novamente!",
                        modifier = Modifier.offset(y = 3.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color.Black
                        )
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Email:",
                        )
                        BasicTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 2.dp,
                                    color = colorResource(R.color.Torquoise),
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .padding(20.dp, 12.dp),
                            value = email,
                            onValueChange = { email = it},
                            singleLine = true,
                            cursorBrush = Brush.verticalGradient(listOf(Turquoise, Verdin)),
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Senha:",
                        )
                        BasicTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 2.dp,
                                    color = colorResource(R.color.Torquoise),
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .padding(20.dp, 12.dp),
                            value = senha,
                            onValueChange = { senha = it},
                            singleLine = true,
                            cursorBrush = Brush.verticalGradient(listOf(Turquoise, Verdin)),
                            visualTransformation = PasswordVisualTransformation(),
                        )
                    }

                    Button(
                        onClick = {
                            if(email.isEmpty() || senha.isEmpty()){
                                Toast.makeText(mainActivity, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                            }else {
                                CoroutineScope(Main).launch {
                                    pessoaList = viewModel.loginPessoa(email, senha)

                                    if (pessoaList.isNotEmpty()) {

                                        val pessoaName = pessoaList[0].nome
                                        val pessoa = pessoaList[0]
                                        pessoa.logado = true
                                        viewModel.upsertPessoa(pessoa)
                                        Toast.makeText(
                                            mainActivity,
                                            "Bem vindo $pessoaName",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        navController.navigate(rotas.Agenda)
                                    } else {
                                        Toast.makeText(
                                            mainActivity,
                                            "Email ou senha incorretos",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        },
                        modifier = Modifier.size(width = 180.dp, height = 38.dp),
                    ) {
                        Text(
                            text = "Entrar",
                        )
                    }
                    }
                }
            }
        }
    }
}
