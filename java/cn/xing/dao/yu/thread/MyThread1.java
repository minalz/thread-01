package cn.xing.dao.yu.thread;

/**
 * A：自定义一个类，继承Thread，这个类称为线程类
 */
public class MyThread1 extends Thread{

    // 重写run方法
    @Override
    public void run() {
        // 这里就是线程要执行的代码
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + "..." + i);
        }
    }

}

class ThreadDemo01{

    public static void main(String[] args) {
        // C: 创建线程类的对象
        MyThread1 mt1 = new MyThread1();
        MyThread1 mt2 = new MyThread1();
        // 给线程起名字
        mt1.setName("halou");
        mt2.setName("heihei");
        // D: 启动线程
//        mt.run();
        mt1.start();
        mt2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "......." + i);
        }
    }
}
