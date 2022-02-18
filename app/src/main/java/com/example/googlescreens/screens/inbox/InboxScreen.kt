package com.example.googlescreens.screens.inbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlescreens.R
import com.example.googlescreens.model.EmailModel
import java.text.DateFormat
import java.util.Date

@Preview
@Composable
fun InboxScreen() {
  EmailList(
      emailsList = listOf(
          EmailModel(
              "Amazon Pay India", "Hi Nikhil your payment of Rs xx is successful", Date(), false,
              R.drawable.google_logo
          )
      )
  )
}

@Composable
fun EmailList(emailsList: List<EmailModel>) {
  LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 8.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    item {
      Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Inbox")
      }
    }
    repeat(5) {
      items(emailsList) { email ->
        EmailRow(email)
      }
    }
  }
}

@Composable
fun EmailRow(emailItem: EmailModel) {
  Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "sender image",
        modifier = Modifier
            .width(48.dp)
            .height(48.dp)
    )
    Column(modifier = Modifier.fillMaxWidth()) {
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(emailItem.senderName.orEmpty())
        Text(DateFormat.getDateTimeInstance().format(emailItem.receivedAt!!))
      }
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(emailItem.content.orEmpty(), modifier = Modifier.fillMaxWidth(0.8F))
        Icon(
            painterResource(id = R.drawable.ic_outline_star_border_24),
            contentDescription = "make favourite", modifier = Modifier.size(24.dp).fillMaxWidth(0.2F)
        )
      }
    }
  }
}