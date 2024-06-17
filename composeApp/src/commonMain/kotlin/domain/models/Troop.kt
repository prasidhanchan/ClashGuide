package domain.models

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
@Serializable
data class Troop(
    val _id: String,
    val name: String,
    val description: String,
    val image: String,
    val color: String,
    val isSuperTroop: Boolean
)
