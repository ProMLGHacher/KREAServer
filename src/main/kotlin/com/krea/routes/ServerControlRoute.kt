package com.krea.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.serverControlRoute() {
    route("/secret") {

        get {

            val rt = Runtime.getRuntime()
            val proc = rt.exec("python C:\\Users\\Neo\\Desktop\\SERVER\\restart.py")
            call.respond("Ok")

        }

    }
}