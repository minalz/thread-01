package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description: 重入锁的测试
 * @author: oldman
 * @date: 2020-03-16 23:57
 **/
public class TestDemo2 {

    public synchronized void demo(){
        System.out.println("demo1 -- " + this);
        demo2();
    }

    public void demo2(){
        synchronized (this){
            System.out.println("demo2 -- " + this);
        }
    }

    public static void main(String[] args) {
        TestDemo2 td = new TestDemo2();
        td.demo();
    }
}
