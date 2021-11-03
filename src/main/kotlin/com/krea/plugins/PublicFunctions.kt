package com.krea.plugins

import io.ktor.application.*
import java.text.SimpleDateFormat
import java.util.*

private val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

const val color_red = "\u001b[31m"
const val color_reset = "\u001b[0m"

fun logging(call: ApplicationCall) {
    println(color_red + call.request.local.method.toString() + color_reset + " | " + sdf.format(Date()) + " | " + call.request.local.uri)
}