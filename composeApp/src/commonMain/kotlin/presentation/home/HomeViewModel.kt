package presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.TroopRepository
import kotlinx.coroutines.Dispatchers
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

    private fun getAllTroops() {
        uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            val response = troopRepository.getTroops()
            if (!response.data.isNullOrEmpty() && !response.isLoading!!) {
                withContext(Dispatchers.Main) {
                    uiState.update {
                        it.copy(
                            troopList = response.data!!,
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
}