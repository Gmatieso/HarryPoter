package com.example.harrypotter.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.harrypotter.domain.items.CharacterItem
import com.example.harrypotter.ui.nav.Screens
import com.example.harrypotter.ui.theme.HarryPotterTheme
import com.example.harrypotter.ui.vm.HarryPotterViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(harryPotterViewModel: HarryPotterViewModel, navController: NavController) {
    val characters = harryPotterViewModel.characters.observeAsState(listOf()).value  //converts LiveData object into state object that can be observed by the UI.

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Harry Potter", fontWeight = FontWeight.Bold) })

        }
    ) {
        LazyColumn {

            items(characters) { character ->

                CharacterCard(character = character, navController = navController)

            }

        }
    }
}

@Composable
fun CharacterCard(character: CharacterItem, navController: NavController) {

    Card(

        elevation = 7.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 7.dp, bottom = 7.dp, start = 14.dp, end = 14.dp)
            .clickable {
                navController.navigate(Screens.Details.route + "/${character.id}")
            }
    ) {

        Row {

            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(175.dp)
                    .height(115.dp)
            )

            Column(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)) {

                Text(text = character.name, fontWeight = FontWeight.Bold)
                Text(text = character.species, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }

        }

    }

}


