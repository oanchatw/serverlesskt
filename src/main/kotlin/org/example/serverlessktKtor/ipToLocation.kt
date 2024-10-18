package org.example.serverlessktKtor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable


private const val FIELDS = "country,regionName,city,query"

private const val BASE_URL = "http://ip-api.com/json/"

@Serializable
data class LocationResponse(val country: String, val regionName: String, val city: String, val query: String)


suspend fun getLocation(ip: String, client: HttpClient): LocationResponse {

    val url = buildString {
        append(BASE_URL)
        if (ip != "localhost" && ip != "_gateway") {
            append("/$ip")
        }
    }

    val response = client.get(url) {
        parametersOf("fields", FIELDS)
    }

    return response.body()!!
}