package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description: 售票演示
 * @author: oldman
 * @date: 2020-03-14 15:58
 **/
public class SellTicketThread extends Thread {

    private static int tickets = 100;


    @Override
    public void run() {
        while(true){
            if(tickets > 0){
                System.out.println(this.getName() + "--出票：" + tickets);
                // 票-1
                tickets--;
            }
        }
    }
}

class SellTicketDemo{
    public static void main(String[] args) {
        SellTicketThread stt1 = new SellTicketThread();
        SellTicketThread stt2 = new SellTicketThread();
        SellTicketThread stt3 = new SellTicketThread();
        SellTicketThread stt4 = new SellTicketThread();

        stt1.setName("窗口1");
        stt2.setName("窗口2");
        stt3.setName("窗口3");
        stt4.setName("窗口4");

        stt1.start();
        stt2.start();
        stt3.start();
        stt4.start();

    }
}
