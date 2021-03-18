package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description: 消费手机的任务
 * @author: oldman
 * @date: 2020-03-15 12:23
 **/
public class ConsumeTask implements Runnable {
//    private PhoneFactory pf = new PhoneFactory();

    private PhoneFactory pf;

    public ConsumeTask(PhoneFactory pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
        while (true){
            pf.get();
        }
    }
}
