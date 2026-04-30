package com.mentalscore.ingestion.util

import java.security.MessageDigest

object EventIdGenerator {

    fun generate(location: String, timestamp: Long): String {
        val input = "$location-$timestamp"
        val md = MessageDigest.getInstance("SHA-256")
        val hash = md.digest(input.toByteArray())

        return hash.joinToString("") { "%02x".format(it) }
    }
}