package facadepattern.facade;

import facadepattern.subsystem.Amplifier;
import facadepattern.subsystem.InputSource;
import facadepattern.subsystem.TheaterLights;

public class MusicFacade {

    private static final int MUSIC_VOLUME = 30;
    private static final int MUSIC_BRIGHTNESS = 50;

    private final Amplifier amplifier;
    private final TheaterLights theaterLights;

    public MusicFacade(Amplifier amplifier, TheaterLights theaterLights) {
        this.amplifier = amplifier;
        this.theaterLights = theaterLights;
    }

    public void startMusic() {
        System.out.println("Starting music...");
        try {
            theaterLights.setBrightness(MUSIC_BRIGHTNESS);
            amplifier.on();
            amplifier.setInputSource(InputSource.RADIO);
            amplifier.setVolume(MUSIC_VOLUME);
        } catch (RuntimeException e) {
            stopEverything();
            throw new IllegalStateException("Could not start music: " + e.getMessage(), e);
        }
    }

    public void stopMusic() {
        System.out.println("Stopping music...");
        stopEverything();
    }

    private void stopEverything() {
        theaterLights.on();
        if (amplifier.isOn()) {
            amplifier.off();
        }
    }
}