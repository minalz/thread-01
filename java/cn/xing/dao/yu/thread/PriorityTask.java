package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description: 线程的默认优先级都是：5
 * @author: oldman
 * @date: 2020-03-14 15:02
 **/
public class PriorityTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);

            Thread.yield();
        }
    }
}

class PriorityDemo{
    public static void main(String[] args) {
        // 创建任务对象
        PriorityTask pt = new PriorityTask();
        // 创建线程对象
        Thread t1 = new Thread(pt, "halou");
        Thread t2 = new Thread(pt, "heiehi");
        Thread t3 = new Thread(pt, "houhou");

        // 获取优先级
//        System.out.println(t1.getPriority());
//        System.out.println(t2.getPriority());
//        System.out.println(t3.getPriority());

        t3.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();


        t2.start();
        t3.start();
    }

    /**
     * 线程一共有6种状态(生命周期)，4种创建方法
     * NOW RUNNABLE WAITING TIMED_WAITTING BLOCKED TERMINAL
     * 1.继承Thread(本质就是去实现Runnable的接口的)
     * 2.实现Runable接口
     * 3.实现Callable/Future
     * 4.线程池Executor
     */
}
