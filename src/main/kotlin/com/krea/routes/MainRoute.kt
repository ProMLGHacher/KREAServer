package com.krea.routes

import com.krea.plugins.logging
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.mainRoute() {
    route("/") {
        get {

            logging(call)
            call.respondText("Работает!")

        }

        post {
            call.respond("This is a main route")
        }
    }
}
