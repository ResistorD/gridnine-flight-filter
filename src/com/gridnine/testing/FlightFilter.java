package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FlightFilter {

    private FlightFilter() {
    }

    public static List<Flight> excludeByRule(List<Flight> flights, FlightFilterRule rule) {
        Objects.requireNonNull(flights, "flights must not be null");
        Objects.requireNonNull(rule, "rule must not be null");

        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight == null) {
                continue;
            }
            if (!rule.shouldExclude(flight)) {
                result.add(flight);
            }
        }
        return result;
    }
}
