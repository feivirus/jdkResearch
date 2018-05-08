package com.feivirus.designpattern.create.staticfactory;

import com.feivirus.designpattern.domain.Car;

/**
 * 
 * @author feivirus
 * 工厂模式
 * 场景:
 * 1.构造方法参数比较多,对象复杂.由工厂产生产品
 * 2.直接用new的不需要用工厂模式
 * 优点:
 * 1.是一个具体的类，有一个create方法，通过if/switch返回
 * 2.create方法是静态的，所以静态工厂
 * 缺点:
 * 1.扩展性差，除了添加新的产品类，每次还需要修改静态工厂类
 * 2.不支持不同产品的构造方法参数不一样 *
 * 
 */
public class StaticFactory {
    public static void main(String[] args) {
        Car car = CarStaticFacory.createCar("bmw");
        
        System.out.println(car.getName());
    }
}
