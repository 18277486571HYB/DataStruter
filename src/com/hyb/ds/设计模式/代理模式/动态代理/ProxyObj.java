package com.hyb.ds.设计模式.代理模式.动态代理;

import com.hyb.ds.设计模式.代理模式.Interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObj {
    private Object target;

    public ProxyObj(Object target) {
        this.target = target;
    }
    public Object proxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(target,args);
            }
        });
    }
}

class Test{
    public static void main(String[] args) {
        Interface proxy = (Interface) new ProxyObj(new TargetObj()).proxy();
        proxy.test();
    }
}
