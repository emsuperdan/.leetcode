import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// ### Android中的代理模式十分常见，根据代码来归类。主要分为静态代理模式和动态代理模式
// 一、静态代理
// 小民在公司上班时，遇到被老板拖欠工资的情况，这种情况下小民准备通过法律途径来解决问题，那么就需要请代理律师来作为自己的诉讼人，我们将诉讼流程抽象在一个接口类中

public class proxyPattern {
    public static void main(String[] args) {
        ILawsuit nongming = new Nongmingong();
        //静态代理
        // ILawsuit lawyer = new Lawyer(nongming);
        // lawyer.submit();
        // lawyer.burden();
        // lawyer.finish();

        //动态代理
        //跳过new对象这步,在运行时动态通过反射机制生成代理者对象；
        ILawsuit dynamicProxy = (ILawsuit) Proxy.newProxyInstance(
                nongming.getClass().getClassLoader(),
                new Class[] { ILawsuit.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 调用被代理类对象的方法
                        Object result = method.invoke(obj, args);
                        return result;
                    }
                });

        dynamicProxy.submit();
        dynamicProxy.burden();
        dynamicProxy.finish();
    }
}

// 事务接口
interface ILawsuit {
    // 提交诉讼材料
    void submit();

    // 诉讼举证
    void burden();

    // 诉讼结束
    void finish();
}

// 被代理类(农民工) 实际逻辑实现
class Nongmingong implements ILawsuit {
    @Override
    public void submit() {
        System.out.println("这是我的诉讼材料");
    }

    @Override
    public void burden() {
        System.out.println("请帮我举证");
    }

    @Override
    public void finish() {
        System.out.println("诉讼结束了");
    }
}

// 代理类(代理律师) 无实际逻辑实现，但可进行额外逻辑添加
class Lawyer implements ILawsuit {
    private ILawsuit mLawsuit;

    // 传入一个被代理类对象
    public Lawyer(ILawsuit lawsuit) {
        this.mLawsuit = lawsuit;
    }

    @Override
    public void submit() {
        mLawsuit.submit();
    }

    @Override
    public void burden() {
        mLawsuit.burden();
    }

    @Override
    public void finish() {
        mLawsuit.finish();
    }
}
