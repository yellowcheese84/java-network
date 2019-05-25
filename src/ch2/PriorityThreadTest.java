package ch2;

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

public class PriorityThreadTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start Main..");
        System.out.println("Thread.MAX_PRIORITY: " + Thread.MAX_PRIORITY);
        System.out.println("Thread.MIN_PRIORITY: " + Thread.MIN_PRIORITY);
        System.out.println("Thread.NORM_PRIORITY: " + Thread.NORM_PRIORITY);

        // 스레드를 생성하고 시작시킨다.
        // 기본적으로 Thread.NORM_PRIORITY, 즉 5의 우선순위 값을 갖게 된다.
        Thread t = new Thread(new PriorityThread());
        t.start();
        Thread.sleep(500);

        // 우선순위를 Thread.MIN_PRIORITY, 즉 1로 바꾼다.
        t.setPriority(Thread.MIN_PRIORITY);
        Thread.sleep(500);

        // 우선순위를 8로 바꾼다.
        t.setPriority(8);
        Thread.sleep(500);

        // 우선순위를 Thread.MAX_PRIORITY, 즉 10으로 바꾼다.
        t.setPriority(Thread.MAX_PRIORITY);
        Thread.sleep(500);

        // 스레드를 종료시킨다.
        t.interrupt();

        System.out.println("End Main..");
    }


    private static class PriorityThread implements Runnable {

        @Override
        public void run() {
            try {
                // isIntterrupted() 메소드를 while문 조건으로 사용한다.
                // 만약, 이 스레드에서 interrupt() 메소드를 호출하면
                // isInterrupted() 메소드는 true를 리턴해서 while문을 빠져나가게 된다.
                while (!Thread.currentThread().isInterrupted()) {
                    // PriorityThread의 우선순위를 출력한다.
                    System.out.println("Priority: " + Thread.currentThread().getPriority());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                // 예상했던 예외이브로 무시한다.
            }
        }
    }
}
