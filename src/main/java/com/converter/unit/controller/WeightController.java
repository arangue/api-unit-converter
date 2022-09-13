package com.converter.unit.controller;

import com.converter.unit.domain.enums.WeightUnit;
import com.converter.unit.exception.InvalidUnitException;
import com.converter.unit.service.WeightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class WeightController {

    private final WeightService service;

    public WeightController(WeightService service) {
        this.service = service;
    }

    @GetMapping("/weight")
    public ResponseEntity<?> weight(){
        return ResponseEntity.ok().body(WeightUnit.values());
    }

    @GetMapping("/weight/{unit}")
    public ResponseEntity<?> defaultWeight(@PathVariable String unit) throws InvalidUnitException {
        return ResponseEntity.ok().body(service.convert(unit, 1.0));
    }

    @GetMapping("/weight/{unit}/{amount}")
    public ResponseEntity<?> defaultWeight(@PathVariable String unit, @PathVariable Double amount) throws InvalidUnitException {
        return ResponseEntity.ok().body(service.convert(unit, amount));
    }
}
