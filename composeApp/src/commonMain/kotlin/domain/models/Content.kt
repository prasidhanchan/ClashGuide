package domain.models

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
@Serializable
data class Content(
    val content: List<Troop>,
    val empty: Boolean,
    val first: Boolean,
    val last: Boolean,
    val number: Int,
    val totalPages: Int
)
