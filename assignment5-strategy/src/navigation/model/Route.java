package navigation.model;

public record Route(String modeName, String from, String to, double distanceKm, double durationMinutes) {

    public String summary() {
        return String.format("%-17s %s -> %s | %.1f km | %.0f min", modeName, from, to, distanceKm, durationMinutes);
    }
}
