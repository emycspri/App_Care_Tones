package com.example.caretones

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun InicioCareTones(navController: NavController, modifier: Modifier = Modifier) {
    val layoutDirection = LocalLayoutDirection.current

    Column(
        modifier = Modifier
            .background(Branco),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row (modifier
            .padding(0.dp, 40.dp,0.dp,0.dp)
        ){
            val imagem1 = painterResource(R.drawable.logo_caretones)
            Image(
                painter = imagem1,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 1.0f, // Valor de alpha válido entre 0 (transparente) e 1 (opaco)
                modifier = Modifier.size(340.dp)
            )
        }

        Row (modifier
            .padding(0.dp, 0.dp,0.dp,140.dp)
        ){
        Text(
            text = "Care Tones",
            style = TextStyle(
                fontFamily = FontFamily.Cursive,
                fontSize = 55.sp,
                color = Color.Black
            )
        )
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate(rotas.Cadastro)
                },
                modifier = Modifier.size(width = 180.dp, height = 42.dp),
            ) {
                Text(
                    text = "Criar conta",
                )
            }
            Button(
                onClick = {
                    navController.navigate(rotas.Login)
                },
                modifier = Modifier.size(width = 180.dp, height = 42.dp),
            ) {
                Text(
                    text = "Fazer Login",
                )
            }
        }
    }
}