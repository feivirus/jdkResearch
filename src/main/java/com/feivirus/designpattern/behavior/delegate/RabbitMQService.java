package com.feivirus.designpattern.behavior.delegate;

public class RabbitMQService implements BusinessService{

    @Override
    public void doProcessing() {
        System.out.println(this.getClass().getName() + " do processing");
    }    
}
