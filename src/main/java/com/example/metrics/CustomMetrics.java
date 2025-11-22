package com.example.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final MeterRegistry registry;
    private Counter customCounter;

    public CustomMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    public void init() {
        customCounter = Counter.builder("my_custom_counter")
                .description("Custom counter example")
                .register(registry);
    }

    public void increment() {
        customCounter.increment();
    }
}
