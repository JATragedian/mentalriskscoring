package com.mentalscore.ingestion.mapper

import com.mentalscore.ingestion.client.model.WeatherResponse
import com.mentalscore.ingestion.model.WeatherEvent
import com.mentalscore.contract.WeatherEvent as AvroWeatherEvent


fun WeatherResponse.toEvent(location: String): WeatherEvent {
    return WeatherEvent(
        location = location,
        temperature = main.temp,
        humidity = main.humidity,
        pressure = main.pressure,
        timestamp = System.currentTimeMillis()
    )
}

fun WeatherEvent.toAvro(): AvroWeatherEvent {
    return AvroWeatherEvent.newBuilder()
        .setLocation(location)
        .setTemperature(temperature)
        .setHumidity(humidity)
        .setPressure(pressure)
        .setTimestamp(timestamp)
        .build()
}