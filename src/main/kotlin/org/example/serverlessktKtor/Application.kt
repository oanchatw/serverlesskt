package org.example.org.example.serverlessktKtor

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import  io.ktor.client.plugins.contentnegotiation.ContentNegotiation as ClientContentNegotiation
import  io.ktor.server.plugins.contentnegotiation.ContentNegotiation as ServerContentNegotiation


import  io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import org.example.serverlessktKtor.getLocation

val client = HttpClient(CIO) {

    install(ClientContentNegotiation) {
        json()
    }
}


val server = embeddedServer(Netty, port = 8080) {
    install(ServerContentNegotiation) {
        json()
    }
    routing {
        get("/") {
            call.respondText  ("Hello, world!")
        }

        get("/ip") {
            call.respondText  (call.request.local.remoteHost)
        }

        get("/location") {
            val ip = call.request.local.remoteHost
            val location = getLocation(ip, client)
            call.respond(location)
        }
    }
}


fun main() {
    server.start(wait = true)
}