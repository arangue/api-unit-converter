package com.converter.unit.controller;

import com.converter.unit.exception.InvalidUnitException;
import com.converter.unit.service.LengthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
public class LengthController {

    private final LengthService service;

    public LengthController(LengthService service) {
        this.service = service;
    }

    public enum units {
        mile, kilometer, yard, meter, centimeter, foot, inch, millimeter
    }

    @GetMapping("/length")
    public ResponseEntity<?> length() {
        return new ResponseEntity<>(units.values(), HttpStatus.OK);
    }

    @GetMapping("/length/{unit}")
    public ResponseEntity<?> defaultLength(@PathVariable String unit) throws InvalidUnitException {
        return ResponseEntity.ok().body(service.convert(unit, 1.0));
    }

    @GetMapping("/length/{unit}/{amount}")
    public ResponseEntity<?> defaultLength(@PathVariable String unit, @PathVariable Double amount) throws InvalidUnitException {
        return ResponseEntity.ok().body(service.convert(unit, amount));
    }
}