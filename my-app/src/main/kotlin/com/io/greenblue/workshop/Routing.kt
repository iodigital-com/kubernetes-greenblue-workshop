package com.io.greenblue.workshop

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val jsonBody = """
            {
              "message": "Hello Blue World!"
            }
    """.trimMargin()
    routing {
        get("/") {
             call.respondText(jsonBody, ContentType.Application.Json)
        }
    }
}
