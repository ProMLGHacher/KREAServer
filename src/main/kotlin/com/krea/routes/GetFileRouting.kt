package com.krea.routes

import com.krea.plugins.logging
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.io.File

var filename = "ля.mp3"

fun Route.getFile() {
    route("/getFile") {

        get {
            val files = File("C:/serverFolder/").listFiles()
            call.respondText(files.joinToString { it.name })
        }

        get("/mp3") {
            logging(call)
            // get filename from request url
            val file = File("C:/serverFolder/$filename")
            if(file.exists()) {
                // Uncomment if you wont download
//                call.response.header(
//                HttpHeaders.ContentDisposition,
//                ContentDisposition.Attachment.withParameter(ContentDisposition.Parameters.FileName, "lll.mp3")
//                    .toString()
//                )
                call.respondFile(file)
            }
            else call.respond(HttpStatusCode.NotFound)

        }

        get("/{name}") {
            logging(call)
            // get filename from request url
            val fname = call.parameters["name"]!!
            val file = File("C:/serverFolder/$fname")
            if(file.exists()) {
                // Uncomment if you wont download
//                call.response.header(
//                HttpHeaders.ContentDisposition,
//                ContentDisposition.Attachment.withParameter(ContentDisposition.Parameters.FileName, "lll.mp3")
//                    .toString()
//                )
                call.respondFile(file)
            }
            else call.respond(HttpStatusCode.NotFound)
        }

        var fileDescription = ""
        var fileName = ""

        post("/upload") {
            val multipartData = call.receiveMultipart()

            multipartData.forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        fileDescription = part.value
                    }
                    is PartData.FileItem -> {
                        fileName = part.originalFileName as String
                        var fileBytes = part.streamProvider().readBytes()
                        File("C:/serverFolder/$fileName").writeBytes(fileBytes)
                    }
                }
            }

            call.respondText("$fileDescription is uploaded to 'uploads/$fileName'")

        }

    }
}