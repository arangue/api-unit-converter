package com.converter.unit.service;

import com.converter.unit.domain.Length;
import com.converter.unit.exception.InvalidUnitException;

public class LengthService {
    public Length convert(String unit, Double amount) throws InvalidUnitException {

        switch (unit){
            case "mile"      : return convertMile(amount);
            case "kilometer" : return convertKilometer(amount);
            case "yard"      : return convertYard(amount);
            case "meter"     : return convertMeter(amount);
            case "foot"      : return convertFoot(amount);
            case "inch"      : return convertInch(amount);
            case "centimeter": return convertCentimeter(amount);
            case "millimeter": return convertMillimeter(amount);
            default:           throw new InvalidUnitException("", 400);
        }
    }

    private Length convertMeter(Double amount) {
        Length l = new Length();

        l.setMillimeter(amount/1000);
        l.setCentimeter(amount*100);
        l.setMile(amount/1609340);
        l.setKilometer(amount/1000000);
        l.setYard(amount/914);
        l.setMeter(amount);
        l.setFoot(amount/305);
        l.setInch(amount/25.4);

        return l;
    }

    private Length convertMillimeter(Double amount) {
        Length l = new Length();

        l.setMillimeter(amount);
        l.setMile(amount/1609340);
        l.setKilometer(amount/1000000);
        l.setYard(amount/914);
        l.setMeter(amount/1000);
        l.setFoot(amount/305);
        l.setInch(amount/25.4);

        return l;
    }

    private Length convertInch(Double amount) {
        Length l = new Length();

        l.setInch(amount);
        l.setMile(amount/63360);
        l.setKilometer(amount/39370);
        l.setYard(amount/36);
        l.setMeter(amount/39.37);
        l.setFoot(amount/12);
        l.setCentimeter(amount*2.54);
        l.setMillimeter(amount*25.4);

        return l;
    }

    private Length convertFoot(Double amount) {
        Length l = new Length();

        l.setFoot(amount);
        l.setMile(amount/5280);
        l.setKilometer(amount/3281);
        l.setYard(amount/3);
        l.setMeter(amount/3.281);
        l.setInch(amount*12);
        l.setCentimeter(amount*30.48);
        l.setMillimeter(amount*304.8);

        return l;
    }

    private Length convertCentimeter(Double amount) {
        Length l = new Length();

        l.setCentimeter(amount);
        l.setMile(amount/160934);
        l.setKilometer(amount/100000);
        l.setYard(amount/91.44);
        l.setMeter(amount/100);
        l.setFoot(amount/30.48);
        l.setInch(amount/2.54);
        l.setMillimeter(amount/10);

        return l;
    }

    private Length convertMile(Double amount) {
        Length l = new Length();

        l.setMile(amount);
        l.setKilometer(amount*1.60934);
        l.setYard(amount*1760);
        l.setMeter(amount*1.60934*100);
        l.setFoot(amount*5280);
        l.setInch(amount*63360);
        l.setCentimeter(amount*160934);
        l.setMillimeter(amount*1609000);

        return l;
    }

    private Length convertKilometer(Double amount) {
        Length l = new Length();

        l.setKilometer(amount);
        l.setMile(amount/1.60934);
        l.setMeter(amount*1000);
        l.setYard(amount*1093.61);
        l.setFoot(amount*3280.84);
        l.setInch(amount*63360);
        l.setCentimeter(amount*100000);
        l.setMillimeter(amount*1609000);

        return l;
    }

    private Length convertYard(Double amount) {
        Length l = new Length();

        l.setYard(amount);
        l.setKilometer(amount*914.4);
        l.setMile(amount/1760);
        l.setMeter(amount*0.9144);
        l.setFoot(amount*3);
        l.setInch(amount*36);
        l.setMillimeter(amount*914.4);
        l.setCentimeter(amount*1.94);

        return l;
    }
}
