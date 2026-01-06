package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeNowRule implements FlightFilterRule {

    @Override
    public boolean shouldExclude(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments == null || segments.isEmpty()) {
            return false;
        }
        // В практике Gridnine проверяют вылет ПЕРВОГО сегмента
        LocalDateTime departure = segments.get(0).getDepartureDate();
        return departure.isBefore(LocalDateTime.now());
    }
}
