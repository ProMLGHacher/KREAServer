package com.krea.routes

import com.krea.plugins.logging
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import java.io.File


fun Route.mp3Route() {
    route("/mp3") {

        get("/{name}") {
            filename = call.parameters["name"]!!
            call.respondRedirect("https://server.krea-company.keenetic.pro/mp3/static/index.html")
        }

        static("static") {
            files("C:\\Users\\Neo\\Desktop\\SERVER\\KREAServer\\src\\main\\resources\\player")
        }

    }
}