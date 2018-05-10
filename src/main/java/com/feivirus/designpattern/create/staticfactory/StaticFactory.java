package com.feivirus.designpattern.create.staticfactory;

import java.util.ArrayList;
import java.util.List;

import com.feivirus.designpattern.create.staticfactory.BMWCar;
import com.feivirus.designpattern.create.staticfactory.Car;

/**
 * 
 * @author feivirus
 * 工厂模式
 * 场景:
 * 1.构造方法参数比较多,很多参数固定，可以统一填充.对象复杂.由工厂产生产品 。参数不固定，用Builder模式
 * 2.直接用new的不需要用工厂模式
 * 3.产品拆分出两层,工厂未拆分
 * 优点:
 * 1.是一个具体的类，有一个create方法，通过if/switch返回
 * 2.create方法是静态的，所以静态工厂
 * 缺点:
 * 1.扩展性差，除了添加新的产品类，每次还需要修改静态工厂类
 * 2.不支持不同产品的构造方法参数不一样 *
 * 参考
 * https://blog.csdn.net/zxt0601/article/details/52798423
 */
public class StaticFactory {
    public static void main(String[] args) {
    	//静态工厂
        Car car = CarStaticFacory.createCar("bmw");        
        System.out.println(car.getName());
        
        Car carRefection = CarStaticFacory.createCar(BMWCar.class);        
        System.out.println("反射 " + carRefection.getName());
        
        //多种方法的静态工厂
        Car multiFuncBenz = MultiFuncCarStaticFactory.createBenzCar();
        System.out.println(multiFuncBenz.getName());       
    }
}
