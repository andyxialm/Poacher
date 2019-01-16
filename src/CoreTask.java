import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class CoreTask {
    private static final int RANGE_DURATION_START = 3000;
    private static final int RANGE_DURATION_END = 6000;

    private boolean mDirectionUp = true;
    private boolean mAlive = true;

    public void run() {
        mAlive = true;
        runInternal();
    }

    public void stopTask() {
        mAlive = false;
    }

    private void runInternal() {

        while (mAlive) {
            try {
                Point startPoint = getNextSwipeStartPoint();
                Point endPoint = getNextSwipeEndPoint();
                String command = String.format("adb shell input swipe %d %d %d %d",
                        startPoint.x, startPoint.y,
                        endPoint.x, endPoint.y);
                Runtime.getRuntime().exec(command);
                System.out.println(command);

                mDirectionUp =!mDirectionUp;
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(getRandomDuration());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getRandomDuration() {
        return new Random().nextInt(RANGE_DURATION_END - RANGE_DURATION_START) + RANGE_DURATION_START;
    }

    /**
     * 120 - 720 随机数
     * @return x 坐标
     */
    private int getRandomX() {
        return new Random().nextInt(400) + 200;
    }

    private Point getNextSwipeStartPoint() {
        int x = getRandomX();
        return mDirectionUp ? new Point(x, 400) : new Point(x, 1200);
    }

    private Point getNextSwipeEndPoint() {
        int x = getRandomX();
        return mDirectionUp ? new Point(x, 700) : new Point(x, 400);
    }
}
