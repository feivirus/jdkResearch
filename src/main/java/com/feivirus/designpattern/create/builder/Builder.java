package com.feivirus.designpattern.create.builder;

/**
 * Builder 模式参考链接
 * http://www.importnew.com/6605.html
 * http://www.cnblogs.com/happyhippy/archive/2010/09/01/1814287.html
 * http://www.importnew.com/8937.html
 * @author feivirus
 *
 */
public class Builder {
    public static void main(String[] args) {
        Person person = new Person.Builder().setAddress("xixi").build();
        
        System.out.println(person.getAddress());
    }
}
