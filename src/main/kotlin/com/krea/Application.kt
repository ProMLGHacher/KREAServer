package com.krea

import com.krea.plugins.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)



@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    install(ContentNegotiation) {
        gson()
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }
    install(WebSockets)

    configureRouting()

    routing {
        webSocket("/chat") {
            send("You are connected!")
            for(frame in incoming) {
                frame as? Frame.Text ?: continue
                val receivedText = frame.readText()
                send("You said: $receivedText")
            }
        }
    }
}

