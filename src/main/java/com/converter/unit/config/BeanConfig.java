package com.converter.unit.config;

import com.converter.unit.service.LengthService;
import com.converter.unit.service.TemperatureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public LengthService getTournamentService() {
        return new LengthService();
    }

    @Bean
    public TemperatureService getTemperatureService() {
        return new TemperatureService();
    }
}
