package singleInstance;

//静态内部类单例(饿汉式单例的静态内部类版本)
public class SingleInstance4 {
    private SingleInstance4(){
    }

    public static SingleInstance4 getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public static class InstanceHolder{
        public static final SingleInstance4 INSTANCE = new SingleInstance4();
    }
}


