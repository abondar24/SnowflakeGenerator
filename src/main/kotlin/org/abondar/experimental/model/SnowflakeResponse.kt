package org.abondar.experimental.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SnowflakeResponse (

   @JsonProperty(value = "snowflake_id")
   val snowflakeId: Long
)