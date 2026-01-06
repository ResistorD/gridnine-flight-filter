package com.gridnine.testing;

import java.util.List;

public class ArrivalBeforeDepartureRule implements FlightFilterRule {

    @Override
    public boolean shouldExclude(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments == null || segments.isEmpty()) {
            return false;
        }

        for (Segment s : segments) {
            if (s.getArrivalDate().isBefore(s.getDepartureDate())) {
                return true;
            }
        }
        return false;
    }
}
