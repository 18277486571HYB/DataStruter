package com.hyb.ds.设计模式.代理模式.静态代理;

import com.hyb.ds.设计模式.代理模式.Interface;

public class ProxyObj implements Interface {

    private final Interface target;

    public ProxyObj(Interface target) {
        this.target = target;
    }

    @Override
    public void test() {
        target.test();
    }
}

class Test{
    public static void main(String[] args) {
        ProxyObj proxyObj = new ProxyObj(new TargetObj());
        proxyObj.test();
    }
}