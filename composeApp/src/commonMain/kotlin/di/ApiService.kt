package di

import domain.utils.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class ApiService(
    private val httpClient: HttpClient
) {
    /**
     * Function to retrieve all troops.
     * @return Returns a [HttpResponse]
     */
    suspend fun getAllTroops(): HttpResponse {
        return httpClient.get("$BASE_URL/get-all-troops?size=10")
    }
}