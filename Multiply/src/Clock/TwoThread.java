package Clock;

public class TwoThread extends Thread{

    private StartStopClock clock;
    private volatile boolean isRunning = true;

    public TwoThread(StartStopClock clock) {
        this.clock = clock;
    }

    public void stopTread() {
        isRunning = false;
    }

    @Override
    public void run() {
        int count = 0;
        while (isRunning) {
                count++;
                if (count%1000 == 0) {
                  System.out.println("count = " + count);
                }
            }
    }
}
