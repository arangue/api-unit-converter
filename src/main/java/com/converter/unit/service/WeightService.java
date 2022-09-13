package com.converter.unit.service;

import com.converter.unit.domain.Weight;
import com.converter.unit.exception.InvalidUnitException;

public class WeightService {

    public Weight convert(String unit, Double amount) throws InvalidUnitException {
        switch(unit) {
            case "stone"    : return convertStone(unit,amount);
            case "pound"    : return convertPound(unit,amount);
            case "ounce"    : return convertOunce(unit,amount);
            case "kilogram" : return convertKilogram(unit,amount);
            case "gram"     : return convertGram(unit,amount);
            case "milligram": return convertMilligram(unit,amount);
            default         : throw new InvalidUnitException(String.format("%s is not a valid unit", unit), 400);
        }
    }

    private Weight convertMilligram(String unit, Double amount) {
        Weight w = new Weight();

        w.setMilligram(amount);
        w.setGram(amount/1000);
        w.setKilogram(amount/1000000);
        w.setStone(amount/6350000);
        w.setPound(amount/453592);
        w.setOunce(amount/28350);

        return w;
    }

    private Weight convertGram(String unit, Double amount) {
        Weight w = new Weight();

        w.setGram(amount);
        w.setMilligram(amount*1000);
        w.setKilogram(amount/1000);
        w.setStone(amount/6350);
        w.setPound(amount/453.592);
        w.setOunce(amount/28.35);

        return w;
    }

    private Weight convertKilogram(String unit, Double amount) {
        Weight w = new Weight();

        w.setKilogram(amount);
        w.setGram(amount*1000);
        w.setMilligram(amount*1000000);
        w.setStone(amount/6.35);
        w.setPound(amount*2.205);
        w.setOunce(amount*35.274);

        return w;
    }

    private Weight convertOunce(String unit, Double amount) {
        Weight w = new Weight();

        w.setOunce(amount);
        w.setStone(amount/224);
        w.setPound(amount/16);
        w.setKilogram(amount/35.274);
        w.setGram(amount*28.3495);
        w.setMilligram(amount*28349.5);

        return w;
    }

    private Weight convertPound(String unit, Double amount) {
        Weight w = new Weight();

        w.setPound(amount);
        w.setStone(amount/14);
        w.setOunce(amount*16);
        w.setKilogram(amount*0.453592);
        w.setGram(amount*453.592);
        w.setMilligram(amount*453592);

        return w;
    }

    private Weight convertStone(String unit, Double amount) {
        Weight w = new Weight();

        w.setStone(amount);
        w.setPound(amount*14);
        w.setOunce(amount*224);
        w.setKilogram(amount*6.3529);
        w.setGram(amount*6350.29);
        w.setMilligram(amount*6350290);

        return w;
    }
}
