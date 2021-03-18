package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description: 内部类实现多线程
 * @author: oldman
 * @date: 2020-03-15 13:45
 **/
public class InnerThreadDemo {
    public static void main(String[] args) {
        // 方式1：继承Therad
        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + i);

                    }
                }
        ).start();

        // 方式2： 实现Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        // 变态版：
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "...111..." + i);

                }
            }

//            public void run(){
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + "...222..." + i);
//
//                }
//            }
        }).start();
    }
}
