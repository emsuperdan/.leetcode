package singleInstance;

//饿汉式
public class SingleInstance1 {
    private SingleInstance1(){
    }

    //在SingleInstance类加载的时候就初始化
    public static SingleInstance1 instance = new SingleInstance1();

    public static SingleInstance1 getInstance(){
        return instance;
    }
}


