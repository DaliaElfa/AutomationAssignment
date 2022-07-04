package base;

public class PageBase {

    public void sleep(Integer milliSeconds) {
        long secondsLong = (long) milliSeconds;
        try {
            Thread.sleep(secondsLong);
        } catch (Exception e) {
            System.out.println(e);
            // InterruptedException
        }
    }

}
