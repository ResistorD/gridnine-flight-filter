package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        print("Исходный набор", flights);

        List<Flight> rule1 = FlightFilter.excludeByRule(flights, new DepartureBeforeNowRule());
        print("После исключения перелётов с вылетом до текущего момента, остались:", rule1);

        List<Flight> rule2 = FlightFilter.excludeByRule(flights, new ArrivalBeforeDepartureRule());
        print("После исключения перелётов с сегментами, где прилёт раньше вылета, остались", rule2);

        List<Flight> rule3 = FlightFilter.excludeByRule(flights, new GroundTimeMoreThanTwoHoursRule());
        print("После исключения перелётов, где суммарное время на земле > 2 часов, остались", rule3);
    }

    private static void print(String title, List<Flight> flights) {
        System.out.println("\n=== " + title + " ===");
        for (Flight f : flights) {
            System.out.println(f);
        }
    }
}
