package data

import di.ApiService
import domain.models.Content
import domain.models.DataOrException
import domain.models.Troop
import io.ktor.client.call.body
import io.ktor.http.isSuccess

class TroopRepository(
    private val apiService: ApiService
) {
    suspend fun getTroops(): DataOrException<List<Troop>, Boolean, Exception> {
        val dataOrException: DataOrException<List<Troop>, Boolean, Exception> = DataOrException()

        try {
            dataOrException.isLoading = true
            val response = apiService.getAllTroops()

            if (response.status.isSuccess()) {
                val content: Content = response.body()
                dataOrException.data = content.content
                dataOrException.isLoading = false
            } else {
                dataOrException.isLoading = false
                throw Exception(response.status.toString())
            }
        } catch (e: Exception) {
            dataOrException.isLoading = false
            dataOrException.exception = e
        }

        return dataOrException
    }
}