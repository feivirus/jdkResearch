package com.feivirus.designpattern.behavior.templatemethod;

public class PinganInsuranceCompany extends InsuranceCompany{

    @Override
    public void quote() {
        System.out.println("平安报价");
    }

    @Override
    public void check() {
        System.out.println("平安核保");
    }

    @Override
    public void pay() {
        System.out.println("平安出单");
    }

}
