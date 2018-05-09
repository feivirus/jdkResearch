package com.feivirus.designpattern.create.builder;

/**
 * Builder 模式参考链接
 * http://www.importnew.com/6605.html
 * @author feivirus
 *
 */
public class Builder {
    public static void main(String[] args) {
        Person person = new Person.Builder().setAddress("xixi").build();
        
        System.out.println(person.getAddress());
    }
}
