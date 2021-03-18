package cn.xing.dao.yu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: EhanceProject
 * @description: 会出现重复票 跳票 和 负票
 * 原因：1。多线程程序
 * 2。多个线程共享资源
 * 3。操作资源的代码有多行
 * 4。CPU的随机切换
 *
 * 同步可以解决安全问题的根本原因就在那个对象上，该对象如同锁的功能，这个对象必须是唯一的
 *
 * 注意事项：
 * 1。同步代码块中，只能包含操作资源的代码，不能乱包
 * 2。同步代码块的锁可以是任意的，但是必须是唯一的
 *
 * 非静态同步方法的锁是this
 * 任何非静态方法，都有一个隐含的对象，就是this
 * 静态同步方法的锁是 类的字节码对象 类.class
 *
 * 如果一个方法内部,所有代码都需要被同步,那么就用同步方法
 * 同步方法的锁是this
 * @author: oldman
 * @date: 2020-03-14 16:07
 **/
public class SellTicketTask implements Runnable {

    private int tickets = 100;

    private Object obj = new Object();

    private Lock l = new ReentrantLock();

    @Override
    public void run() {
//    public synchronized void run() {
//        synchronized (SellTicketTask.class){
//        synchronized (obj){
        l.lock();
        while(true){
                System.out.println(Thread.currentThread().getName() + "获取锁了");
                if(tickets > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " -- 出票：" + tickets);
                    tickets--;
                }else{
                    System.out.println(Thread.currentThread().getName() + "跳出循环了");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "释放锁了");
            }
        l.unlock();
//        }
    }
}

class SellTicketTaskDemo{
    public static void main(String[] args) {
//        SellTicketTask stt = new SellTicketTask();
//        Thread t1 = new Thread(stt, "窗口1");
//        Thread t2 = new Thread(stt, "窗口2");
//        Thread t3 = new Thread(stt, "窗口3");
//        Thread t4 = new Thread(stt, "窗口4");
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        // C: 创建任务对象
        SellTicketTask stt = new SellTicketTask();
        // D: 创建线程池
        ExecutorService es = Executors.newFixedThreadPool(4);
        // E: 直接执行任务
        es.execute(stt);
        es.execute(stt);
        es.execute(stt);
        es.execute(stt);
    }
}