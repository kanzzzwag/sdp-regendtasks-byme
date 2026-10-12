package facadepattern.subsystem;

public class PopcornPopper {

    private boolean isOn;
    private boolean isPopping;

    public boolean isOn() {
        return isOn;
    }

    public void on(){
        isOn = true;
        System.out.println("Popcorn popper is turned on");
    }

    public void pop(){
        ensureOn();
        isPopping = true;
        System.out.println("Popcorn popper is popping");
    }

    public void off(){
        ensureOn();
        isPopping = false;
        isOn = false;
        System.out.println("Popcorn popper is turned off");
    }

    private void ensureOn(){
        if (!isOn) {
            throw new IllegalStateException("Popcorn popper is already off!");
        }
    }
}
