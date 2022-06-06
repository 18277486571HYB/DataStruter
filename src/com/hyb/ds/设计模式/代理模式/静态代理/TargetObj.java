package com.hyb.ds.设计模式.代理模式.静态代理;

import com.hyb.ds.设计模式.代理模式.Interface;

public class TargetObj implements Interface {
    @Override
    public void test() {

        System.out.println("目标对象");
    }


}
