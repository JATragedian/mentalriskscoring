package com.mentalscore.ingestion.mapper

import com.mentalscore.ingestion.client.model.WeatherResponse
import com.mentalscore.ingestion.model.WeatherEvent
import com.mentalscore.ingestion.util.EventIdGenerator
import com.mentalscore.contract.WeatherEvent as AvroWeatherEvent


fun WeatherResponse.toEvent(location: String): WeatherEvent {
    val timestamp = System.currentTimeMillis()

    return WeatherEvent(
        eventId = EventIdGenerator.generate(location, timestamp),
        location = location,
        temperature = main.temp,
        humidity = main.humidity,
        pressure = main.pressure,
        timestamp = timestamp
    )
}

fun WeatherEvent.toAvro(): AvroWeatherEvent {
    return AvroWeatherEvent.newBuilder()
        .setEventId(eventId)
        .setLocation(location)
        .setTemperature(temperature)
        .setHumidity(humidity)
        .setPressure(pressure)
        .setTimestamp(timestamp)
        .build()
}