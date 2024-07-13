package org.abondar.experimental.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.abondar.experimental.model.SnowflakeResponse


fun Application.configureRouting() {
    routing {
        get("/snowflake") {
            call.respond(SnowflakeResponse(100500))
        }
    }
}
