package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description:
 * @author: oldman
 * @date: 2020-03-14 17:05
 **/
public class DeadLockTask implements Runnable {

    // 定义两把锁
    private Object locka = new Object();
    private Object lockb = new Object();
    // 定义一个标记 控制线程执行逻辑
    public boolean flag = true;
    @Override
    public void run() {
        if(flag){
            while (true){
                synchronized (locka){
                    System.out.println("if.....locka");
                    synchronized (lockb){
                        System.out.println("if.....lockb");
                    }
                }
            }
        }else{
            while (true){
                synchronized (lockb){
                    System.out.println("else.....locka");
                    synchronized (locka){
                        System.out.println("else.....locka");
                    }
                }
            }
        }
    }
}

class DeadLockDemo{
    public static void main(String[] args) {
        DeadLockTask dlt = new DeadLockTask();
        Thread t1 = new Thread(dlt);
        Thread t2 = new Thread(dlt);

        t1.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dlt.flag = false;
        t2.start();
    }
}
