package com.cahek2009.limfedmadness.domain.model

// PROBABLY WILL BE CHANGED IN THE FUTURE
data class Scene(

    val id: String,
    val background: String? = null,
    val character: String? = null,
    val text: String,
    val choices: List<PlayerChoice> = emptyList()
)
