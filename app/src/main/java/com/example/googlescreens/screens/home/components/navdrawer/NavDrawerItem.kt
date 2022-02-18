package com.example.googlescreens.screens.home.components.navdrawer

import com.example.googlescreens.R

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String,unread: String?) {
  object AllInboxes : NavDrawerItem("all_inboxes", R.drawable.ic_outline_all_inbox_24, "All inboxes",null)
  object Inbox : NavDrawerItem("inbox",R.drawable.ic_baseline_inbox_24 , "Inbox","99+")
  object Unread : NavDrawerItem("unread", R.drawable.ic_outline_mark_email_unread_24, "Unread","99+")
  object Starred : NavDrawerItem("stared", R.drawable.ic_outline_star_outline_24, "Starred","99+")
  object Snoozed : NavDrawerItem("snoozed", R.drawable.ic_outline_access_time_24, "Snoozed","99+")
  object Important : NavDrawerItem("important", R.drawable.ic_outline_label_24, "Important","99+")
}