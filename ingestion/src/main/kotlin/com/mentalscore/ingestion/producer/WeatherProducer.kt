package com.mentalscore.ingestion.producer

import com.mentalscore.ingestion.model.WeatherEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class WeatherProducer(
    private val kafkaTemplate: KafkaTemplate<String, WeatherEvent>
) {

    fun send(event: WeatherEvent) {
        kafkaTemplate.send("weather.raw", event.location, event)
    }
}