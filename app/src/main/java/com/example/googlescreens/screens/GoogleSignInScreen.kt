package com.example.googlescreens.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlescreens.R
import com.example.googlescreens.ui.theme.Blue700
import com.example.googlescreens.ui.theme.Blue900
import com.example.googlescreens.ui.theme.Typography

@Preview
@Composable
fun SignInScreen() {
  Scaffold(modifier = Modifier.fillMaxSize()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
      Card(
          modifier = Modifier
              .fillMaxWidth()
              .padding(bottom = 16.dp),
          elevation = 4.dp,
          shape = RoundedCornerShape(4.dp),
          border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colors.onSurface.copy(0.2F))
      ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 32.dp)
        ) {
          Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              modifier = Modifier.fillMaxWidth()
          ) {
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "google logo", modifier = Modifier
                .width(80.dp)
                .height(48.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Sign in", style = Typography.body1.copy(
                color = MaterialTheme.colors.onSurface, fontSize = 20.sp
            ),
                fontWeight = FontWeight.Bold
            )
            Text(text = "Use your Google Account")
          }
          OutlinedTextField(
              value = "", onValueChange = {},
              modifier = Modifier.fillMaxWidth(),
              label = {
                Text(text = "Email or phone")
              }
          )
          Text(
              text = "Forgot email?", modifier = Modifier.padding(bottom = 32.dp),
              style = Typography.body1.copy(color = Blue900)
          )
          Text(text = "Not your computer? Use Guest mode to sign in privately.")
          Text(
              text = "Learn more", modifier = Modifier.padding(bottom = 16.dp),
              style = Typography.body1.copy(color = Blue900)
          )

          Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
          ) {
            TextButton(
                onClick = { /*TODO*/ }, Modifier.background(color = Color.Transparent),
                contentPadding = PaddingValues(0.dp)
            ) {
              Text(
                  text = "Create account", style = Typography.body1.copy(color = Blue700),
                  textAlign = TextAlign.Start
              )
            }
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Blue700, contentColor = Color.White
            )
            ) {
              Text(text = "Next")
            }
          }
        }

      }

      Row(
          modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp, start = 2.dp, end = 2.dp),
          verticalAlignment = Alignment.Bottom
      ) {
        Box(modifier = Modifier.align(Alignment.Bottom)) {
          LanguageDropDown {
            Log.d("GoogleSignInScreen", "SignInScreen: $it")
          }
        }
        Spacer(modifier = Modifier.fillMaxWidth(0.25F))
        Box(modifier = Modifier.fillMaxWidth()) {
          Text(text = "Help", style = Typography.body1,modifier = Modifier.align(Alignment.BottomStart))
          Text(text = "Privacy", style = Typography.body1, modifier = Modifier.align(Alignment.BottomCenter))
          Text(text = "Terms", style = Typography.body1, modifier = Modifier.align(Alignment.BottomEnd))
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LanguageDropDown(onOptionChanged: (String) -> Unit) {
  val isExpanded = remember { mutableStateOf(false) }
  val languages = listOf("English", "German", "French")
  val selectedLanguageText = remember { mutableStateOf(languages[0]) }

  ExposedDropdownMenuBox(
      expanded = isExpanded.value,
      onExpandedChange = {
        isExpanded.value = !isExpanded.value
      }, modifier = Modifier.wrapContentSize()
  ) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentSize()
    ) {
      Text(
          text = selectedLanguageText.value, style = Typography.body1.copy(fontSize = 14.sp),
      )
      Icon(
          painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
          contentDescription = "open language dropdown",
      )
    }
    ExposedDropdownMenu(
        expanded = isExpanded.value,
        onDismissRequest = {
          isExpanded.value = false
        }, modifier = Modifier.fillMaxWidth(0.35F)

    ) {
      languages.forEach { selectionOption ->
        DropdownMenuItem(
            onClick = {
              selectedLanguageText.value = selectionOption
              onOptionChanged(selectionOption)
              isExpanded.value = false
            }
        ) {
          Text(text = selectionOption, style = Typography.body1.copy(fontSize = 14.sp))
        }
      }
    }
  }
}