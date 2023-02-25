package com.kingsland.home.presentation.model

data class Project(
  val id: Int,
  val title: String,
  val priority: Int,
  val description: String,
  val dateCreated: String,
  // TODO: Add contributors later
)
