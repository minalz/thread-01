package cn.xing.dao.yu.thread;

import java.util.concurrent.*;

/**
 * @program: EhanceProject
 * @description:
 * @author: oldman
 * @date: 2020-03-15 13:39
 **/
public class SumTask implements Callable<Integer> {
    private int num;

    public SumTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i <= num; i++) {

            result += i;
        }
        return result;
    }
}

class CallableDemo{
    public static void main(String[] args) {
        // 创建线程任务
        SumTask st = new SumTask(100);
        // 获取线程池
        ExecutorService es = Executors.newFixedThreadPool(1);
        // 执行任务
        Future<Integer> future = es.submit(st);
        // 等待运算结束，获取结果
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
