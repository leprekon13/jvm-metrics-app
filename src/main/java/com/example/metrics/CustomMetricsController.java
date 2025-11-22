package com.example.metrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomMetricsController {

    private final CustomMetrics customMetrics;

    public CustomMetricsController(CustomMetrics customMetrics) {
        this.customMetrics = customMetrics;
    }

    @GetMapping("/custom-metric")
    public String incrementCustomMetric() {
        customMetrics.increment();
        return "Метрика увеличена!";
    }
}
