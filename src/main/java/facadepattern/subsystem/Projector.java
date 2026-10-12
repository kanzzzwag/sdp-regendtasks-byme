package facadepattern.subsystem;

public class Projector {

    private enum Mode { WIDESCREEN, STANDARD }

    private static final int WARM_UP_SECONDS = 3;
    private static final int ONE_SECOND_MS = 1000;

    private boolean isOn;
    private boolean isWarmedUp;
    private InputSource inputSource;
    private Mode mode;

    public boolean isOn() {
        return isOn;
    }

    public void on(){
        isOn = true;
        System.out.println("Projector warming up...");
        for(int i = 1; i <= WARM_UP_SECONDS; i++){
            System.out.println(i);
            waitOneSecond();
        }
        isWarmedUp = true;
        System.out.println("Projector is now on");
    }

    public void off(){
        isOn = false;
        isWarmedUp = false;
        System.out.println("Projector is now off");
    }

    public void setInputSource(InputSource inputSource) {
        ensureReady();
        if(inputSource == null){
            throw new IllegalArgumentException("Input source can't be null!");
        }
        this.inputSource = inputSource;
        System.out.println("Input source is now set to " + inputSource);
    }

    public void setWideScreenMode(){
        ensureReady();
        this.mode = Mode.WIDESCREEN;
        System.out.println("Screen mode set to widescreen");
    }

    private void waitOneSecond(){
        try {
            Thread.sleep(ONE_SECOND_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Projector warm-up was interrupted", e);
        }
    }

    private void ensureReady(){
        if (!isOn) {
            throw new IllegalStateException("Projector is off!");
        }
        if (!isWarmedUp){
            throw new IllegalStateException("Projector isn't warmed up!");
        }
    }
}
