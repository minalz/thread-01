package cn.xing.dao.yu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: EhanceProject
 * @description: 生产车间的代码
 * @author: oldman
 * @date: 2020-03-14 22:53
 **/
public class PhoneFactory {

    private String name;
    private double price;

    private int i = 0;

    private boolean hasPhone = false;

    // 定义锁对象
    private Lock l = new ReentrantLock();

    // 定义生产者的condition对象
    private Condition pro_con = l.newCondition();

    // 定义消费者的condition对象
    private Condition con_con = l.newCondition();

    // 对外提供生产手机的功能
//    public synchronized void produce(){
    public void produce(){
        l.lock();
        while (hasPhone){
            System.out.println(Thread.currentThread().getName() + "-- 阻塞了");
            try {
//                this.wait();
                pro_con.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(i % 2 == 0){
            this.name = "IPhone7 Plus";
            this.price = 6888.00;
        }else{
            this.name = "红米4";
            this.price = 799.00;
        }
        this.hasPhone = true;
//        this.notifyAll();
        con_con.signal();
        System.out.println(Thread.currentThread().getName() + "：" + "-- 生产了");
        i++;
        l.unlock();
    }

    // 对外提供一个获取手机的功能
//    public synchronized void get(){
    public void get(){
        l.lock();
        while(!hasPhone){
            System.out.println(Thread.currentThread().getName() + "-- 阻塞了");
            try {
//                this.wait();
                con_con.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.hasPhone = false;
//        this.notifyAll();
        pro_con.signal();
        // 消费手机
        System.out.println(Thread.currentThread().getName() + " ：" + name + " ... " + price);
        l.unlock();
    }
}

class ProduceConsumeTest{
    public static void main(String[] args) {
        PhoneFactory pf = new PhoneFactory();

        ProduceTask pt = new ProduceTask(pf);
        ConsumeTask ct = new ConsumeTask(pf);

        Thread t1 = new Thread(pt,"生产者1");
        Thread t2 = new Thread(pt,"生产者2");

        Thread t3 = new Thread(ct,"消费者1");
        Thread t4 = new Thread(ct,"消费者2");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
