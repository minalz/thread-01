package cn.xing.dao.yu.thread;

/**
 * @program: EhanceProject
 * @description:单例
 * 死锁：两个以上的线程争夺共享资源，产生的一种互相等待的现象
 * @author: oldman
 * @date: 2020-03-14 16:48
 **/
public class Singleton {

    // 创建对象
    private static Singleton instance = new Singleton();

    // 私有化构造函数
    private Singleton() {

    }

    // 提供对外的对象接口
    public static Singleton getInstance(){
        return instance;
    }

}

class Singleton2{
    private static Singleton2 instatnce = null;
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        // 双重检查锁
        if(instatnce != null){
        // 这次判断 是为了在对象创建后 以后的线程 不再判断同步
            synchronized (Singleton2.class){
            // 加同步 解决的是第一次new对象时的安全问题
                if(instatnce != null){
                // 这次判断 是为了第一次new对象进行创建
                    instatnce = new Singleton2();
                }

            }
        }
        return instatnce;
    }

}


