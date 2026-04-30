package com.mentalscore.processing.service

import com.mentalscore.contract.PartialRiskEvent
import com.mentalscore.contract.WeatherEvent
import com.mentalscore.processing.util.EventIdGenerator
import org.springframework.stereotype.Service


@Service
class RiskCalculator {

    fun calculate(event: WeatherEvent): PartialRiskEvent {
        val risk = when {
            event.temperature < -10 -> 0.7
            event.temperature < 0 -> 0.5
            event.temperature > 30 -> 0.6
            else -> 0.2
        }

        return PartialRiskEvent.newBuilder()
            .setEventId(EventIdGenerator.generate())
            .setParentEventId(event.eventId)
            .setTimestamp(event.timestamp)
            .setLocation(event.location)
            .setValue(risk)
            .setSource("weather")
            .build()
    }
}