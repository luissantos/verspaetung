package pt.luissantos.verspaetung.lines.services;

import pt.luissantos.verspaetung.lines.models.LineStatus;

import java.util.Optional;

public interface DelayService {

    public Optional<LineStatus> getDelayStatus(String line);
}
