package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class GroundTimeMoreThanTwoHoursRule implements FlightFilterRule {

    private static final Duration LIMIT = Duration.ofHours(2);

    @Override
    public boolean shouldExclude(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments == null || segments.size() < 2) {
            return false;
        }

        Duration groundTotal = Duration.ZERO;

        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();

            // если вдруг данные кривые (например, пересечение) — считаем 0, но можно и исключать
            if (nextDeparture.isAfter(arrival)) {
                groundTotal = groundTotal.plus(Duration.between(arrival, nextDeparture));
            }
        }

        return groundTotal.compareTo(LIMIT) > 0;
    }
}
