package com.hspedu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> bossCls = Class.forName("com.hspedu.reflection.Boss");
        Object o = bossCls.newInstance();
        Method hi = bossCls.getDeclaredMethod("hi", String.class);//OK
        hi.invoke(o, "韩顺平教育~");
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));
        System.out.println(say.invoke(null, 200, "李四", '女'));

        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型=" + reVal.getClass());//String


        Method m1 = bossCls.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2的运行类型=" + reVal2.getClass());//Monster


    }
}

class Monster {}
class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }
}

