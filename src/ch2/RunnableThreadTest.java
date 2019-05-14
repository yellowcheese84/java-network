package ch2;

class RunnableThread implements Runnable {
    // run()을 오버라딩해서 재정의한다.
    @Override
    public void run() {
        System.out.println("Runnable 인터페이스를 구현");
    }
}

public class RunnableThreadTest {

    public static void main(String[] args) {
        // Thread 생성자에 RunnableThread 인스턴스를 파라미터로 전달한다.
        Thread t = new Thread(new RunnableThread());
        t.start();
    }
}
