package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description:
 * @author: oldman
 * @date: 2020-03-14 16:29
 **/
public class QuestionTest {

    private static boolean isStop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
//            synchronized (QuestionTest.class){
                while(!isStop){
                    System.out.println(i++);
                }
//            }

            System.out.println("子线程停止");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("祝线程设置停止标志");

        isStop = true;

        System.out.println("main 线程停止");
    }
}
