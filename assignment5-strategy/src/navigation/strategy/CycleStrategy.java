package navigation.strategy;

import navigation.model.Route;

public final class CycleStrategy implements RouteStrategy {

    private static final String MODE_NAME = "Cycle";
    private static final double AVERAGE_SPEED_KMH = 15.0;
    private static final double KM_BETWEEN_RESTS = 10.0;
    private static final double REST_MINUTES = 5.0;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String from, String to, double distanceKm) {
        double ridingMinutes = distanceKm / AVERAGE_SPEED_KMH * MINUTES_PER_HOUR;
        return new Route(MODE_NAME, from, to, distanceKm, ridingMinutes + restMinutesFor(distanceKm));
    }

    private double restMinutesFor(double distanceKm) {
        int restStops = (int) (distanceKm / KM_BETWEEN_RESTS);
        return restStops * REST_MINUTES;
    }
}
