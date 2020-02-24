package com.feivirus.classloader;

/**
 * @author feivirus
 * 类加载机制
 * tomcat 不同网站的类加载
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            ClassLoaderTest test = new ClassLoaderTest();
            ClassLoader classLoader = test.getClass().getClassLoader();
            Class clazz = classLoader.loadClass("com.feivirus.classloader.A");

            A a = (A)clazz.newInstance();

            System.out.println(a);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    public A newObjectWithClass() {
        try {
            Class clazz = Class.forName("com.feivirus.classloader.A");

            A a = (A)clazz.newInstance();

            return a;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public A newObject() {
        return new A();
    }

    public A newObjectWithClassLoader() {

        try {
            ClassLoader classLoader = this.getClass().getClassLoader();

            //classLoader = Thread.currentThread().getContextClassLoader();

            //classLoader = ClassLoader.getSystemClassLoader();
            Class clazz = classLoader.loadClass("com.feivirus.classloader.A");

            A a = (A)clazz.newInstance();

            return a;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

class A {
    private Integer value;
}
