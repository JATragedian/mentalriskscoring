package com.mentalscore.ingestion.model

data class WeatherEvent(
    val eventId: String,
    val location: String,
    val temperature: Double,
    val humidity: Int,
    val pressure: Int,
    val timestamp: Long
)
