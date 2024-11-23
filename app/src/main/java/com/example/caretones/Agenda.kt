package com.example.caretones

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caretones.data.Datasource
import com.example.caretones.model.Affirmation
import com.example.caretones.ui.theme.Branco
import com.example.caretones.ui.theme.Clarin
import com.example.caretones.ui.theme.Turquoise

@Composable
fun NavbarAgenda(navController: NavController) {

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

            Spacer(modifier = Modifier.width(105.dp))

            Button(
                onClick = {
                    navController.navigate(rotas.Perfil)
                },
                colors = ButtonDefaults.buttonColors(Color(24, 103, 108))
            ) {
                val imagem2 =
                    painterResource(R.drawable.user) // Variável que armazena o recurso da imagem
                Image(
                    painter = imagem2,
                    contentDescription = null, // Descrição de conteúdo para acessibilidade
                    contentScale = ContentScale.Crop,
                    alpha = 1.0f, // Valor de alpha válido entre 0 (transparente) e 1 (opaco)
                    modifier = Modifier.size(37.dp)
                )
            }
        }
        AffirmationList(
            AffirmationList = Datasource().loadAffirmations(),
            modifier = Modifier,
            navController
        )
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, navController: NavController, modifier: Modifier = Modifier ) {
    val layoutDirection = LocalLayoutDirection.current

    Card(modifier = modifier,
        colors =  CardDefaults.cardColors(colorResource(R.color.Clarin)),
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .background(Clarin),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                modifier = Modifier
                    .size(width = 340.dp, height = 500.dp)
                    .background(Clarin)
            ) {
                Text(
                    text = stringResource(id = R.string.title_consulta),
                    fontFamily = FontFamily.Serif,
                    fontSize = 35.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(8.dp),
                )

                Text(
                    text = LocalContext.current.getString(affirmation.stringResourceId),
                    modifier = Modifier
                        .padding(14.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 22.sp,
                    color = Color.Black,
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    Arrangement.Absolute.Center
                ) {
                    Button(
                        onClick = {
                            navController.navigate(rotas.Visualizar)
                        },
                        colors = ButtonDefaults.buttonColors(Color(32, 97, 91))
                    ) {
                        Text(
                            text = stringResource(id = R.string.botao),
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White,
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AffirmationList(AffirmationList: List<Affirmation>, modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        items(AffirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(20.dp),
                navController = navController
            )
        }
    }
}