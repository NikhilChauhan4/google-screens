package com.example.googlescreens.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.googlescreens.R
import com.example.googlescreens.navigation.GmailNavigation
import com.example.googlescreens.screens.home.components.GmailCloneAppBar
import com.example.googlescreens.screens.home.components.navdrawer.NavDrawer

@Composable
fun HomeScreen(navController: NavHostController){
  val scaffoldState = rememberScaffoldState()
  val scope = rememberCoroutineScope()
  Scaffold(
      scaffoldState = scaffoldState,
      topBar = { GmailCloneAppBar(scaffoldState = scaffoldState, coroutineScope = scope) },
      drawerBackgroundColor = colorResource(id = R.color.purple_500),
      drawerContent = {
        NavDrawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
      },
  ) {
    GmailNavigation(navController = navController)
  }
}