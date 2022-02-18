package com.example.googlescreens.screens.home.components.navdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.googlescreens.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(
  scope: CoroutineScope,
  scaffoldState: ScaffoldState,
  navController: NavHostController
) {
  val items = listOf(
      NavDrawerItem.AllInboxes,
      NavDrawerItem.Inbox,
      NavDrawerItem.Unread,
      NavDrawerItem.Starred,
      NavDrawerItem.Snoozed,
      NavDrawerItem.Important
  )
  Column(modifier = Modifier.fillMaxWidth()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    DrawerHeader()
    Divider()
    items.forEachIndexed { index, item ->
      NavDrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
        navController.navigate(item.route) {
          navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
              saveState = true
            }
          }
          launchSingleTop = true
          restoreState = true
        }
        scope.launch {
          scaffoldState.drawerState.close()
        }
      }, showDivider = index == 0)
    }
  }
}

@Composable
fun DrawerHeader() {
  Row(modifier = Modifier
      .fillMaxWidth()
      .padding(start = 16.dp, bottom = 16.dp, top = 8.dp)) {
    Text(text = "Gmail", style = TextStyle(fontSize = 26.sp))
  }
}

@Composable
fun NavDrawerItem(
  item: NavDrawerItem,
  selected: Boolean,
  onItemClick: (NavDrawerItem) -> Unit,
  showDivider: Boolean = false
) {
  val background = if (selected) R.color.purple_200 else android.R.color.transparent
  if (showDivider) {
    Divider()
  }
  val customItemPadding = if(showDivider.not())
    PaddingValues(start = 16.dp)
  else PaddingValues(start = 16.dp, top = 8.dp, bottom = 8.dp)
  Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
          .fillMaxWidth()
          .clickable(onClick = { onItemClick(item) })
          .padding(customItemPadding)
          .height(45.dp)
          .background(colorResource(id = background))
  ) {
    Image(
        painter = painterResource(id = item.icon),
        contentDescription = item.title,
        colorFilter = ColorFilter.tint(Color.White),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .height(35.dp)
            .width(35.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text(
        text = item.title,
        fontSize = 18.sp,
        color = Color.White
    )
  }
  if (showDivider) {
    Divider()
  }
}