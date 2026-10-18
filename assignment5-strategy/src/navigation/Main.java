package navigation;

import java.util.Map;
import java.util.Objects;
import navigation.context.Navigator;
import navigation.strategy.CarStrategy;
import navigation.strategy.CycleStrategy;
import navigation.strategy.PublicTransportStrategy;
import navigation.strategy.RouteStrategy;
import navigation.strategy.WalkStrategy;

public final class Main {

    private static final String FROM = "Home";
    private static final String TO = "University";
    private static final double DISTANCE_KM = 12.5;
    private static final String[] REQUESTED_MODES = {"walk", "transit", "car"};

    private static final Map<String, RouteStrategy> STRATEGIES_BY_NAME = Map.of(
            "car", new CarStrategy(),
            "walk", new WalkStrategy(),
            "cycle", new CycleStrategy(),
            "transit", new PublicTransportStrategy()
    );

    public static void main(String[] args) {
        demonstrateRuntimeSwitching();
        demonstrateSelectionByName();
    }

    private static void demonstrateRuntimeSwitching() {
        System.out.println("=== Runtime strategy switching ===");
        Navigator navigator = new Navigator(new CarStrategy());
        printPlannedRoute(navigator);
        navigator.setStrategy(new WalkStrategy());
        printPlannedRoute(navigator);
        navigator.setStrategy(new CycleStrategy());
        printPlannedRoute(navigator);
        navigator.setStrategy(new PublicTransportStrategy());
        printPlannedRoute(navigator);
    }

    private static void demonstrateSelectionByName() {
        System.out.println();
        System.out.println("=== Strategy selection by name ===");
        for (String modeName : REQUESTED_MODES) {
            System.out.print("[" + modeName + "] ");
            printPlannedRoute(new Navigator(strategyNamed(modeName)));
        }
    }

    private static RouteStrategy strategyNamed(String modeName) {
        return Objects.requireNonNull(STRATEGIES_BY_NAME.get(modeName), "Unknown travel mode: " + modeName);
    }

    private static void printPlannedRoute(Navigator navigator) {
        System.out.println(navigator.planRoute(FROM, TO, DISTANCE_KM).summary());
    }
}
