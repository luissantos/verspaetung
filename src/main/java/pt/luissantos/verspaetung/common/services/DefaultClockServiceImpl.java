package pt.luissantos.verspaetung.common.services;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DefaultClockServiceImpl implements ClockService {

    @Override
    public LocalTime current() {
        return LocalTime.now();
    }
}
