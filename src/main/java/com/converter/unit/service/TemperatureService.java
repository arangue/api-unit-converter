package com.converter.unit.service;

import com.converter.unit.domain.Temperature;
import com.converter.unit.exception.InvalidUnitException;

public class TemperatureService {

    public Temperature convert(String unit, Double amount) throws InvalidUnitException {

        if ("celsius".equals(unit) || "fahrenheit".equals(unit) || "kelvin".equals(unit)) {
            return convertTemperature(unit, amount);
        }
        else {
            throw new InvalidUnitException(String.format("%s is not a valid unit",unit), 400);
        }
    }

    private Temperature convertTemperature(String unit, Double amount) {
        Temperature t = new Temperature();
        if ("celsius".equals(unit)) {
            t.setCelsius(amount);
            t.setFahrenheit((amount*1.8)+32.0);
            t.setKelvin(amount+273.15);
        } else if ("fahrenheit".equals(unit)) {
            t.setFahrenheit(amount);
            t.setCelsius((amount - 32)*0.55);
            t.setKelvin((amount - 32)*0.55+273.15);
        } else if ("kelvin".equals(unit)) {
            t.setKelvin(amount);
            t.setCelsius(amount-273.15);
            t.setFahrenheit((amount-273.15)*1.8+32.0);
        }
        return t;
    }
}
