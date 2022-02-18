package com.example.googlescreens.model

import androidx.annotation.DrawableRes
import java.util.Date

data class EmailModel(
  var senderName: String?,
  var content: String?,
  var receivedAt: Date?,
  var isStarred: Boolean?,
  @DrawableRes
  var profileImage: Int
)