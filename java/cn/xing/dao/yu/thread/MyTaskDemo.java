package cn.xing.dao.yu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: EhanceProject
 * @description:
 * @author: oldman
 * @date: 2020-03-15 13:35
 **/
public class MyTaskDemo implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "....." + i);

        }
        return null;
    }
}

class MyTaskDemoTest{
    public static void main(String[] args) {
        MyTaskDemo mt = new MyTaskDemo();

        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(mt);
        es.submit(mt);
    }
}
