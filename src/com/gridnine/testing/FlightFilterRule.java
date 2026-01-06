package com.gridnine.testing;

@FunctionalInterface
public interface FlightFilterRule {
    /**
     * @return true, если перелёт должен быть ИСКЛЮЧЁН по данному правилу.
     */
    boolean shouldExclude(Flight flight);
}
