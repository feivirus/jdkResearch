package com.feivirus.designpattern.behavior.templatemethod;

/**
 * 父类为虚拟类，定义各种顺序操作的接口，在各种具体子类中去实现 
 * @author feivirus
 * 多个类实现同一个方法，用策略
 * 多个类实现多个方法，先后有顺序，用模板方法
 */
public class TemplateMethod {
    public static void main(String [] args) {
        InsuranceCompanyTemplate pinganCompany = new PinganInsuranceCompany();
        
        pinganCompany.run();
    }
}
