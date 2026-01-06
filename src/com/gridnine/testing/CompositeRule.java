package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompositeRule implements FlightFilterRule {

    private final List<FlightFilterRule> rules;

    public CompositeRule(FlightFilterRule... rules) {
        this.rules = Arrays.asList(rules);
    }

    @Override
    public boolean shouldExclude(Flight flight) {
        Objects.requireNonNull(flight, "flight must not be null");
        for (FlightFilterRule r : rules) {
            if (r != null && r.shouldExclude(flight)) {
                return true; // исключаем, если сработало хоть одно правило
            }
        }
        return false;
    }
}
