package com.hspedu.reflection.classload_;
public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        B b = new B();
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {
        System.out.println("B() 构造器被执行");
    }
}
