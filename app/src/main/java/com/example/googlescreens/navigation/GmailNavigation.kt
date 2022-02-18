package com.example.googlescreens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlescreens.screens.home.components.navdrawer.NavDrawerItem
import com.example.googlescreens.screens.inbox.InboxScreen

@Composable
fun GmailNavigation(navController: NavHostController) {
  NavHost(navController, startDestination = NavDrawerItem.Inbox.route) {
    composable(NavDrawerItem.AllInboxes.route) {
      InboxScreen()
    }
    composable(NavDrawerItem.Inbox.route) {
      InboxScreen()
    }
    composable(NavDrawerItem.Unread.route) {
      InboxScreen()
    }
    composable(NavDrawerItem.Starred.route) {
      InboxScreen()
    }
    composable(NavDrawerItem.Snoozed.route) {
      InboxScreen()
    }
    composable(NavDrawerItem.Important.route) {
      InboxScreen()
    }
  }
}