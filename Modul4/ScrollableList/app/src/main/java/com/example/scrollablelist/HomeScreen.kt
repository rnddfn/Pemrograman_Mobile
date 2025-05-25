package com.example.scrollablelist

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, viewModel: ItemViewModel) {
    val context = LocalContext.current
    val itemList = viewModel.itemList.collectAsState()
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        LazyColumn {
            items(itemList.value) { item ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(id = item.pictureId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(130.dp)
                                .width(100.dp)
                                .align(Alignment.CenterVertically)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Column(modifier = Modifier
                            .padding(start = 16.dp)
                            .fillMaxWidth()) {

                            Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = stringResource(id = item.description), style = MaterialTheme.typography.bodyMedium)

                            Row(
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(onClick = {
                                    android.util.Log.d("HomeScreen", "Tombol Detail ditekan untuk ${item.name}") // ✅ benar di sini
                                    viewModel.setSelectedItem(item)
                                    navController.navigate("detail_Screen")
                                }) {
                                    Text("Detail")
                                }

                                Button(onClick = {
                                    android.util.Log.d("HomeScreen", "Tombol Explicit Intent ditekan: ${item.url}")
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                                    context.startActivity(intent)
                                }) {
                                    Text("Buka Situs")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}