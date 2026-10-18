package facadepattern.subsystem;

public class TheaterLights {

    private static final int MAX_BRIGHTNESS = 100;
    private static final int MIN_BRIGHTNESS = 0;

    private int brightness;

    public void on() {
        brightness = MAX_BRIGHTNESS;
        System.out.println("Brightness of the lights set to max");
    }

    public void off() {
        brightness = MIN_BRIGHTNESS;
        System.out.println("Brightness of the lights turned off");
    }

    public void setBrightness(int level) {
        if (level > MAX_BRIGHTNESS || level < MIN_BRIGHTNESS) {
            throw new IllegalArgumentException("Brightness level is out the range!");
        }
        brightness = level;
        System.out.println("Brightness level is set to " + level);
    }
}
