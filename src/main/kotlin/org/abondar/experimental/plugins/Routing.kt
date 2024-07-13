package org.abondar.experimental.plugins

import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.abondar.experimental.generator.SnowflakeGenerator
import org.abondar.experimental.model.SnowflakeResponse


fun Application.configureRouting() {
    val machineId = environment.config.property("snowflake.machineId").getString()

    val generator = SnowflakeGenerator(machineId.toLong())

    routing {
        get("/snowflake") {
            val id = generator.generateId()
            call.respond(SnowflakeResponse(id))
        }
    }
}
