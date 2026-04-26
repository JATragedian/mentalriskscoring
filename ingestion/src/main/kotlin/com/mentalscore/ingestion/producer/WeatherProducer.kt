package com.mentalscore.ingestion.producer

import com.mentalscore.ingestion.mapper.toAvro
import com.mentalscore.ingestion.model.WeatherEvent
import com.mentalscore.contract.WeatherEvent as AvroWeatherEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class WeatherProducer(
    private val kafkaTemplate: KafkaTemplate<String, AvroWeatherEvent>
) {

    fun send(event: WeatherEvent) {
        kafkaTemplate.send("weather.raw", event.location, event.toAvro())
    }
}