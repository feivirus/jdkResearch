package com.feivirus.designpattern.behavior.templatemethod;

public abstract class InsuranceCompany {
    public void run() {
        quote();
        check();
        pay();
        order();
    }
    
    protected abstract void quote();
    
    protected abstract void check();
    
    protected abstract void pay();
    
    protected void order() {
        System.out.println("出单中,部分保险公司不支持出单");
    }
}
