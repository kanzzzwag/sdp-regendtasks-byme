package navigation;

import navigation.context.Navigator;
import navigation.strategy.CarStrategy;
import navigation.strategy.CycleStrategy;
import navigation.strategy.WalkStrategy;

public final class Main {

    private static final String FROM = "Home";
    private static final String TO = "University";
    private static final double DISTANCE_KM = 12.5;

    public static void main(String[] args) {
        demonstrateRuntimeSwitching();
    }

    private static void demonstrateRuntimeSwitching() {
        System.out.println("=== Runtime strategy switching ===");
        Navigator navigator = new Navigator(new CarStrategy());
        printPlannedRoute(navigator);
        navigator.setStrategy(new WalkStrategy());
        printPlannedRoute(navigator);
        navigator.setStrategy(new CycleStrategy());
        printPlannedRoute(navigator);
    }

    private static void printPlannedRoute(Navigator navigator) {
        System.out.println(navigator.planRoute(FROM, TO, DISTANCE_KM).summary());
    }
}
