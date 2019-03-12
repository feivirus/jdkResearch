package com.feivirus.designpattern.behavior.templatemethod;

/**
 * 父类为虚拟类，定义各种顺序操作的接口，在各种具体子类中去实现 
 * @author feivirus
 *
 */
public class TemplateMethod {
    public static void main(String [] args) {
        InsuranceCompany pinganCompany = new PinganInsuranceCompany();
        
        pinganCompany.run();
    }
}
