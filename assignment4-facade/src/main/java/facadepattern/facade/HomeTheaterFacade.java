package facadepattern.facade;

import facadepattern.subsystem.*;

public class HomeTheaterFacade {

    private final Amplifier amplifier;
    private final DVDPlayer dvdPlayer;
    private final Projector projector;
    private final Screen screen;
    private final TheaterLights theaterLights;
    private final PopcornPopper popcornPopper;

    private static final int MOVIE_VOLUME = 5;
    private static final int MOVIE_BRIGHTNESS = 10;

    public HomeTheaterFacade(Amplifier amplifier, DVDPlayer dvdPlayer, Projector projector, Screen screen, TheaterLights theaterLights, PopcornPopper popcornPopper) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.screen = screen;
        this.theaterLights = theaterLights;
        this.popcornPopper = popcornPopper;
    }

    public void watchMovie(String title) {
        try {
            startPopcorn();
            prepareRoom();
            startProjector();
            startSound();
            startDVD(title);
        } catch (RuntimeException e) {
            shutDownEverything();
            throw new IllegalStateException("Could not start the movie: " + e.getMessage(), e);
        }
    }

    public void endMovie() {
        dvdPlayer.stop();
        dvdPlayer.eject();
        shutDownEverything();
        System.out.println("Movie ended, disc ejected");
    }

    private void shutDownEverything() {
        theaterLights.on();
        if (popcornPopper.isOn()) {
            popcornPopper.off();
        }
        if (screen.isDown()) {
            screen.raise();
        }
        if (projector.isOn()) {
            projector.off();
        }
        if (amplifier.isOn()) {
            amplifier.off();
        }
        if (dvdPlayer.isPlaying()) {
            dvdPlayer.stop();
        }
        if (dvdPlayer.isOn()) {
            dvdPlayer.off();
        }
        System.out.println("Everything shut down!");
    }

    private void startPopcorn() {
        popcornPopper.on();
        popcornPopper.pop();
    }

    private void prepareRoom() {
        theaterLights.setBrightness(MOVIE_BRIGHTNESS);
        screen.lower();
    }

    private void startProjector() {
        projector.on();
        projector.setInputSource(InputSource.DVD);
        projector.setWideScreenMode();
    }

    private void startSound() {
        amplifier.on();
        amplifier.setInputSource(InputSource.DVD);
        amplifier.setSurroundSound();
        amplifier.setVolume(MOVIE_VOLUME);
    }

    private void startDVD(String title) {
        dvdPlayer.on();
        dvdPlayer.insertDisc(title);
        dvdPlayer.play();
    }
}
