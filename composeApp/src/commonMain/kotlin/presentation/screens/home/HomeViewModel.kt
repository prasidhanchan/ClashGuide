package presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.TroopRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val troopRepository: TroopRepository
) : ViewModel() {

    var uiState = MutableStateFlow(UiState())
        private set

    init {
        getAllTroops()
    }

    /**
     * Function to get all the available troops from the DB
     */
    private fun getAllTroops() {
        uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            val response = troopRepository.getTroops()

            delay(2500L) // Artificial delay to show loading animation
            if (!response.data.isNullOrEmpty() && !response.isLoading!!) {
                val troops = response.data?.filter { !it.isSuperTroop }
                val superTroops = response.data?.filter { it.isSuperTroop }

                withContext(Dispatchers.Main) {
                    uiState.update {
                        it.copy(
                            troopList = troops!!,
                            superTroopList = superTroops!!,
                            isLoading = false
                        )
                    }
                }
            } else {
                withContext(Dispatchers.Main) {
                    uiState.update {
                        it.copy(
                            error = response.exception?.localizedMessage,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun setHasPurchasedPremium(value: Boolean) {
        viewModelScope.launch {
            uiState.update { it.copy(isLoading = true) }
            delay(2000L)

            uiState.update { it.copy(hasPurchasedPremium = value) }

            delay(3000L)
            uiState.update { it.copy(isLoading = false) }
        }
    }
}