package com.hspedu.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
public class Reflection01 {

    public static void main(String[] args) throws Exception {



        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); 
        Method method1 = cls.getMethod(methodName);
        System.out.println("=============================");

        Field nameField = cls.getField("age"); 
        System.out.println(nameField.get(o)); 
        Constructor constructor = cls.getConstructor(); 
        System.out.println(constructor);



        Constructor constructor2 = cls.getConstructor(String.class); 
        System.out.println(constructor2);
    }
}
