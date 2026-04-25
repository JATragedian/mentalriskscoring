package com.mentalscore.ingestion.scheduler

import com.mentalscore.ingestion.service.WeatherIngestionService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class WeatherScheduler(
    private val service: WeatherIngestionService
) {
    @Scheduled(fixedRate = 60000)
    fun run() {
        service.fetchAndSend("moscow")
    }
}