package ch2;

class StopThread implements Runnable {

    // 조건문을 빠져나가기 위해 사용할 플래그 변수다.
    private boolean stopped = false;

    @Override
    public void run() {

        while (!stopped) {
            System.out.println("Thread is alive..");

            try {
                /*
                    이 곳에서 sleep 메소드를 호출하는 이유는 while 같은 반복문을
                    조금의 여유도 없이 수행하면 CPU에 많은 부담을 주기 때문이다.
                 */
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread is dead..");
    }

    // 이 메소드 호출로 StopThread가 멈춘다.
    public void stop() {
        stopped = true;
    }
}

public class StopThreadTest {

    public static void main(String[] args) {

        System.out.println("# Start StopThreadTest.java");
        StopThreadTest stt = new StopThreadTest();
        stt.process();
    }

    public void process() {
        /*
            StopThread 인스턴스를 생성한 후 이 인자를 파라미터로 받는
            스레드 인스턴스를 생성한 후에 출발시킨다.
         */
        StopThread st = new StopThread();
        Thread thread = new Thread(st);
        thread.start();

        try {
            // 1초 간 멈춘다.
            Thread.sleep(1000);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // StopTread를 정지시킨다.
        st.stop();
    }
}
