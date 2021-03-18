package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description: 生产手机的线程任务
 * @author: oldman
 * @date: 2020-03-14 22:59
 **/
public class ProduceTask implements Runnable {

//    private PhoneFactory pf = new PhoneFactory();

    private PhoneFactory pf;

    public ProduceTask(PhoneFactory pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
        while (true){
            pf.produce();
        }
    }
}
