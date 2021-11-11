package com.krea.plugins

import com.krea.routes.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {

        authenticate("auth-jwt") {
            mainRoute()
        }

        customerRoute()
        getFile()
        serverControlRoute()
        mp3Route()

    }
}
