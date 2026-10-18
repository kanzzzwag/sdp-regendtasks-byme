package facadepattern;

import facadepattern.facade.HomeTheaterFacade;
import facadepattern.facade.MusicFacade;
import facadepattern.subsystem.*;

public class Main {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights theaterLights = new TheaterLights();
        PopcornPopper popcornPopper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amplifier, dvdPlayer, projector, screen, theaterLights, popcornPopper);

        System.out.println("=== Demo 1: normal movie night ===");
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();

        System.out.println("\n=== Demo 2: ending a movie that is not playing ===");
        try {
            homeTheater.endMovie();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Demo 3: music mode (second facade) ===");
        MusicFacade music = new MusicFacade(amplifier, theaterLights);
        music.startMusic();
        music.stopMusic();
    }
}