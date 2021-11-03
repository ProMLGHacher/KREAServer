package com.krea.routes

import io.ktor.routing.*

fun Route.serverControlRoute() {
    route("/secret") {

        get {
            val rt = Runtime.getRuntime()
            val proc = rt.exec("name_of_your_application.exe")
            val exitVal = proc.exitValue()
            println("Process exitValue: $exitVal")
        }

    }
}