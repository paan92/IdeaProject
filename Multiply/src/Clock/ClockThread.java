package Clock;


class ClockThread extends Thread {

    private StartStopClock clock;
    private volatile boolean isRunning = true;

    public ClockThread(StartStopClock clock) {
        this.clock = clock;
    }

    public void stopClock() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            clock.setTime();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}