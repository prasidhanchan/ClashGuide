package domain

import androidx.compose.runtime.Stable

@Stable
data class Troop(
    val _id: String,
    val name: String,
    val description: String,
    val image: String,
    val color: String,
    val isSuperTroop: Boolean
)
