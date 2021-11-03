package com.krea.plugins

import com.krea.routes.customerRoute
import com.krea.routes.getFile
import com.krea.routes.mainRoute
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        mainRoute()
        customerRoute()
        getFile()
    }
}
