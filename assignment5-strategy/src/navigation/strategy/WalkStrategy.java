package navigation.strategy;

import navigation.model.Route;

public final class WalkStrategy implements RouteStrategy {

    private static final String MODE_NAME = "Walk";
    private static final double AVERAGE_SPEED_KMH = 5.0;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String from, String to, double distanceKm) {
        double walkingMinutes = distanceKm / AVERAGE_SPEED_KMH * MINUTES_PER_HOUR;
        return new Route(MODE_NAME, from, to, distanceKm, walkingMinutes);
    }
}
