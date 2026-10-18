package navigation.strategy;

import navigation.model.Route;

public final class PublicTransportStrategy implements RouteStrategy {

    private static final String MODE_NAME = "Public transport";
    private static final double AVERAGE_SPEED_KMH = 25.0;
    private static final double WAITING_TIME_MINUTES = 8.0;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String from, String to, double distanceKm) {
        double ridingMinutes = distanceKm / AVERAGE_SPEED_KMH * MINUTES_PER_HOUR;
        return new Route(MODE_NAME, from, to, distanceKm, WAITING_TIME_MINUTES + ridingMinutes);
    }
}
