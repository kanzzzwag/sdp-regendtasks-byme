package facadepattern.subsystem;

public class Amplifier {

    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    private boolean isOn;
    private int volume;
    private InputSource inputSource;
    private boolean isSurroundSoundOn;


    public void setVolume(int volume) {
        ensureOn();
        if( volume < MIN_VOLUME || volume > MAX_VOLUME){
            throw new IllegalArgumentException("Volume must be between " + MIN_VOLUME + " and " + MAX_VOLUME);
        }
        this.volume = volume;
        System.out.println("Amplifier volume set to " + volume);
    }

    public void setInputSource(InputSource inputSource) {
        ensureOn();
        if(inputSource == null){
            throw new IllegalArgumentException("Input source can't be null!");
        }
        this.inputSource = inputSource;
        System.out.println("Amplifier input set to " + inputSource);
    }

    public boolean isOn() {
        return isOn;
    }

    public void on(){
        isOn = true;
        System.out.println("Amplifier is now on");
    }

    public void off(){
        isOn = false;
        isSurroundSoundOn = false;
        System.out.println("Amplifier is now off");
    }

    public void setSurroundSound(){
        ensureOn();
        isSurroundSoundOn = true;
        System.out.println("Surround sound on");
    }

    private void ensureOn(){
        if (!isOn) {
            throw new IllegalStateException("Amplifier is off!");
        }
    }
}
