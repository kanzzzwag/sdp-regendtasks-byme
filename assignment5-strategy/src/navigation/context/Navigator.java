package navigation.context;

import java.util.Objects;
import navigation.model.Route;
import navigation.strategy.RouteStrategy;

public final class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy must not be null");
    }

    public Route planRoute(String from, String to, double distanceKm) {
        return strategy.buildRoute(from, to, distanceKm);
    }
}
