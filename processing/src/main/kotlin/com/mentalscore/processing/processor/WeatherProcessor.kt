package com.mentalscore.processing.processor

import com.mentalscore.contract.PartialRiskEvent
import com.mentalscore.contract.WeatherEvent
import com.mentalscore.processing.service.RiskCalculator
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class WeatherProcessor(
    private val kafkaTemplate: KafkaTemplate<String, PartialRiskEvent>,
    private val riskCalculator: RiskCalculator
) {
    companion object {
        private val log = LoggerFactory.getLogger(WeatherProcessor::class.java)
    }

    @KafkaListener(topics = ["weather.raw"])
    fun listen(event: WeatherEvent) {
        try {
            MDC.put("location", event.location)
            log.info("Processing weather event")
            MDC.clear()

            val result = riskCalculator.calculate(event)
            kafkaTemplate.send("weather.risk", event.location, result)
        } catch (e: Exception) {
            log.error("Failed to process event: $event", e)
        }
    }
}