package singleInstance;

//懒汉式(因为延迟加载了所以叫这个名字)
public class SingleInstance2 {
    private SingleInstance2(){
    }

    public static SingleInstance2 instance;

    public static SingleInstance2 getInstance(){
        //只在用的时候进行初始化 延迟加载
        if(instance == null){
            instance = new SingleInstance2();
        }
        return instance;
    }
}


