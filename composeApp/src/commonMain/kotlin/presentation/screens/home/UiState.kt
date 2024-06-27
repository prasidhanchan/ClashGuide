package presentation.screens.home

import domain.models.Troop

data class UiState(
    var troopList: List<Troop> = emptyList(),
    var superTroopList: List<Troop> = emptyList(),
    var hasPurchasedPremium: Boolean = false,
    var isLoading: Boolean = false,
    var error: String? = null
)
