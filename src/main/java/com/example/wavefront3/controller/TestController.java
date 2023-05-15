package com.example.wavefront3.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MeterRegistry meterRegistry;

    @GetMapping("/")
    public ResponseEntity<?> test() {
        meterRegistry.counter("test.metric", List.of(Tag.of("test", "aaa"))).increment();
        return ResponseEntity.ok().build();
    }

}
