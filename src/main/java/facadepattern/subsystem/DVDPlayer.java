package facadepattern.subsystem;

public class DVDPlayer {
    private boolean isOn;
    private String currentMovie;
    private boolean isPlaying;


    public boolean isOn() {
        return isOn;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void on() {
        isOn = true;
        System.out.println("DVD player now is on");
    }

    public void off() {
        if (isPlaying) {
            throw new IllegalArgumentException("Can't turn off while movie is playing!");
        }
        isOn = false;
        System.out.println("DVD player now is off");
    }

    public void insertDisc(String title) {
        ensureOn();
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title of the disc can't be empty!");
        }
        if (hasDisc()) {
            throw new IllegalStateException("DVD player already has disc inside!");
        }
        currentMovie = title;
        System.out.println("Disc has been inserted. Movie title is " + title);
    }

    public void play() {
        ensureOn();
        if (!hasDisc()) {
            throw new IllegalStateException("Disc absence!");
        }
        isPlaying = true;
        System.out.println("DVD player now is playing");
    }

    public void stop() {
        ensureOn();
        if (!hasDisc()) {
            throw new IllegalStateException("Disc absence!");
        }
        if (!isPlaying) {
            throw new IllegalStateException("Nothing is playing!");
        }
        isPlaying = false;
        System.out.println("DVD player has been stopped");
    }

    public void eject() {
        ensureOn();
        if (!hasDisc()) {
            throw new IllegalStateException("Disc absence!");
        }
        if (isPlaying) {
            throw new IllegalStateException("Can't eject while playing!");
        }
        currentMovie = null;
        System.out.println("Disc has been ejected");
    }

    private void ensureOn() {
        if (!isOn) {
            throw new IllegalStateException("DVD player is off!");
        }
    }

    private boolean hasDisc() {
        return currentMovie != null;
    }
}
