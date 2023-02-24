package singleInstance;

//懒汉式双重判空校验锁
public class SingleInstance3 {
    private SingleInstance3(){
    }

    public static volatile SingleInstance3 instance;

    public static SingleInstance3 getInstance(){
        //第一层判空防止直接接触锁降低效率
        if(instance == null){
            synchronized(SingleInstance3.class){
                if(instance == null){
                    //加了volatile 防止指令重排出现获取到未初始化对象
                    instance = new SingleInstance3();
                }
            }
        }
        return instance;
    }
}


