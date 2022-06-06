package com.hyb.ds.设计模式.工厂模式;

class A {

    private A() {
    }

    private static A a=new A();

    public static A getA(){
        return a;
    }

}

class B{
    private B(){

    }

    private volatile static B b=null;

    public static B getB(){
        if (b==null){

            synchronized (B.class){
                if (b==null){
                    b=new B();
                }
            }
        }
        return b;
    }
}

class C{
    private C(){}

    private static class D{
        private static final C c=new C();
    }
    public static C getC(){
        return D.c;
    }
}


class EnumSingleton {
    private EnumSingleton() {

    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.instance;
    }

    private enum Singleton {
        INSTANCE;

        private final EnumSingleton instance;

        //JVM保证只执行一次
        Singleton() {
            instance = new EnumSingleton();
        }
    }

}

class F{
    private F(){}
    public static F getF(){
        return G.H.f;
    }
    private enum G{
        H;
        private final F f;
        G(){
            f=new F();
        }
    }
}