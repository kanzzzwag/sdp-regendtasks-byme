package navigation.strategy;

import navigation.model.Route;

public final class CarStrategy implements RouteStrategy {

    private static final String MODE_NAME = "Car";
    private static final double AVERAGE_SPEED_KMH = 50.0;
    private static final double TRAFFIC_DELAY_MINUTES = 10.0;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String from, String to, double distanceKm) {
        double drivingMinutes = distanceKm / AVERAGE_SPEED_KMH * MINUTES_PER_HOUR;
        return new Route(MODE_NAME, from, to, distanceKm, drivingMinutes + TRAFFIC_DELAY_MINUTES);
    }
}
