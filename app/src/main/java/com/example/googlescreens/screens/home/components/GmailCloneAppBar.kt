package com.example.googlescreens.screens.home.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GmailCloneAppBar(coroutineScope: CoroutineScope,scaffoldState: ScaffoldState){
  TopAppBar(
      title = {
        Text("Gmail")
      },
      navigationIcon = {
        IconButton(onClick = {
          coroutineScope.launch {
            scaffoldState.drawerState.open()
          }}) {
          Icon(Icons.Filled.Menu, contentDescription = "open navigation drawer")
        }
      },
  )
}