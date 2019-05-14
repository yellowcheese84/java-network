package ch2;

class AdvancedStopThread implements Runnable {
    @Override
    public void run() {

        try {
            /*
                isInterrupted() 메소드를 while문 조건으로 사용한다.
                만약, 이 스레드에서 interrupt() 메소드를 호출하면
                isInterrupted() 메소드는 true를 리턴해서 while문을 빠져나가게 된다.
             */
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is alive..");
                // 0.5초 간 멈춘다.
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            // 예상했던 예외므로 무시한다.
        } finally {
            // 마무리 해야 할 작업이 있다면 이곳에서 정리한다.
            System.out.println("Thread is dead..");
        }
    }
}

public class AdvancedStopThreadTest {

    public static void main(String[] args) {
        System.out.println("# Start AdvancedStopThreadTest.java");
        AdvancedStopThreadTest astt = new AdvancedStopThreadTest();
        astt.process();
    }

    private void process() {

        /*
            AdvancedStopThread 인스턴스를 생성한 후 이 인자를 파라미터로 받는
            쓰레드 인스턴스를 생성한 후에 출발시킨다.
         */
        AdvancedStopThread ast = new AdvancedStopThread();
        Thread thread = new Thread(ast);
        thread.start();

        try {
            // 1초 간 멈춘다.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // AdvancedStopThread를 정지시킨다.
        thread.interrupt();
    }
}
