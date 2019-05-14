package ch2;

class ExtendThread extends Thread {
    // run()을 오버라이딩해서 재정의한다.
    @Override
    public void run() {
        System.out.println("Thread 클래스를 상속");
    }
}

public class ExtendThreadTest {

    public static void main(String[] args) {
        Thread t = new ExtendThread();
        /*
            start()를 이용해서 스레드를 시작시킨다.
            이후 ExtendThread의 run()이 실행되고
            run()이 종료되면 바로 ExtendThread가 소멸된다.
         */
        t.start();
    }
}

