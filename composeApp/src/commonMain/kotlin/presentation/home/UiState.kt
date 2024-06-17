package presentation.home

import domain.models.Troop

data class UiState(
    var troopList: List<Troop> = emptyList(),
    var isLoading: Boolean = false,
    var error: String? = null
)
