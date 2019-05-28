package ch2;

import java.util.Random;

public class ThreadLocalTest {

    // 카운터 변수를 생성한다.
    static volatile int counter = 0;

    // ThreadLocal의 변수를 생성한다.
    static ThreadLocal threadLocal = new ThreadLocalObject();

    public static void main(String[] args) {
        // main 스레드의 value를 출력한다.
        displayValues();

        Runnable runner = new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadLocalTest.class) {
                    // 카운터를 1만큼 증가시킨다.
                    counter++;
                }
                // value를 출력한다.
                displayValues();
                try {
                    Thread.sleep(((Integer)threadLocal.get()).intValue());
                    // value를 출력한다.
                    displayValues();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 스레드 세 개를 생성해서 각 스레드 value를 출력한다.
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(runner);
            t.start();
        }
    }

    // ThreadLocal을 상속한 ThreadLocalObject 클래스를 생성한다.
    private static class ThreadLocalObject extends ThreadLocal {
        Random random = new Random();
        // 초기 값으로 0 ~ 999 사이의 임의 값을 설정한다.
        // initialValue() 메소드의 접근자가 protected임에 주의한다.
        // return 값이 Object임에 주의한다.
        @Override
        protected Object initialValue() {
            return new Integer(random.nextInt(1000));
        }
    }

    private static void displayValues() {
        System.out.println(
                "Thread Name: " + Thread.currentThread().getName()
                + ", initialValue: " + threadLocal.get()
                + ", counter: " + counter
        );
    }
}
