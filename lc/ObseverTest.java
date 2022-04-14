package lc;

import java.util.ArrayList;

public class ObseverTest {
    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        InfoCenter infoCenter = new InfoCenter();
        infoCenter.registerObserver(observer1);
        infoCenter.registerObserver(observer2);

        String msg = "this is msg from infoCenter";
        infoCenter.sendMsg(msg);
    }
}


//消息主体接口
interface Subject{
    //注册观察者方法
    void registerObserver(Observer observer);

    //解除观察者方法
    void unregisterObserver(Observer observer);

    //消息改变通知观察者
    void notifyObservers(String msg);
}

//消息主体实现类:消息中心
class InfoCenter implements Subject{
    private ArrayList<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        // TODO Auto-generated method stub
        observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        // TODO Auto-generated method stub
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        // TODO Auto-generated method stub
        for(Observer observer : observerList){
            observer.updateMsg(msg);
        }
    }

    public void sendMsg(String msg){
        notifyObservers(msg);
    }
    
}



//观察者接口
interface Observer{
    void updateMsg(String msg);
}

//定义多个观察者继承观察者接口
class Observer1 implements Observer{

    @Override
    public void updateMsg(String msg) {
        // TODO Auto-generated method stub
        System.out.println("obsever1:----"+msg);
    }
    
}

class Observer2 implements Observer{

    @Override
    public void updateMsg(String msg) {
        // TODO Auto-generated method stub
        System.out.println("obsever2:----"+msg);
    }
    
}

