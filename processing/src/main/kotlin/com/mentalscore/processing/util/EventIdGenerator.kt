package com.mentalscore.processing.util

import java.util.*

object EventIdGenerator {

    fun generate(): String {
        return UUID.randomUUID().toString()
    }
}