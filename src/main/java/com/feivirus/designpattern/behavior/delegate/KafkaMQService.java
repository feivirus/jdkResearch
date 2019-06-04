package com.feivirus.designpattern.behavior.delegate;

public class KafkaMQService implements BusinessService{

    @Override
    public void doProcessing() {
        System.out.println(getClass().getName() + "  do processing");
    }    
}
