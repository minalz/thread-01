package cn.xing.dao.yu.thread;

/**
 * A: 自定义类 实现Runanle接口 这个类就是任务类
 */
public class MyTask implements Runnable {

    // B: 实现Run方法
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        // C: 创建任务类的对象
        MyTask mt = new MyTask();
        // D: 创建Thread类对象，并且把任务对象作为参数传递
        Thread t1 = new Thread(mt, "汤姆");
        Thread t2 = new Thread(mt, "杰瑞");

        t1.start();
        t2.start();
    }
}
