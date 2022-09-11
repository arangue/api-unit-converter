package com.converter.unit.controller;

import com.converter.unit.exception.InvalidUnitException;
import com.converter.unit.service.TemperatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class TemperatureController {

    private final TemperatureService service;

    public TemperatureController(TemperatureService service) {
        this.service = service;
    }

    public enum units {
        fahrenheit, celsius, kelvin
    }

    @GetMapping("/temperature")
    public ResponseEntity<?> temperature(){
        return ResponseEntity.ok().body(units.values());
    }
    @GetMapping("/temperature/{unit}")
    public ResponseEntity<?> defaultTemperature(@PathVariable String unit) throws InvalidUnitException {
        return ResponseEntity.ok().body(service.convert(unit, 1.0));
    }

    @GetMapping("/temperature/{unit}/{amount}")
    public ResponseEntity<?> defaultTemperature(@PathVariable String unit, @PathVariable Double amount) throws InvalidUnitException {
        return ResponseEntity.ok().body(service.convert(unit, amount));
    }
}
