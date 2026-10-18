package facadepattern.subsystem;

public class Screen {
    private boolean isDown;

    public boolean isDown() {
        return isDown;
    }

    public void lower() {
        if (isDown) {
            throw new IllegalStateException("Screen is already down!");
        }
        isDown = true;
        System.out.println("Screen lowered");
    }

    public void raise() {
        if (!isDown) {
            throw new IllegalStateException("Screen is already raised!");
        }
        isDown = false;
        System.out.println("Screen has been raised");
    }
}
