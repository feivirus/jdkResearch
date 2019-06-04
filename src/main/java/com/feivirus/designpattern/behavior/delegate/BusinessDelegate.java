package com.feivirus.designpattern.behavior.delegate;

public class BusinessDelegate {
    private BusinessService businessService;
    
    public void lookupService(String type) {
        if (type.equals("kafka")) {
            businessService = new KafkaMQService();
        } else if(type.equals("rabbit")) {
            businessService = new RabbitMQService();
        }        
    }
    
    public void doTask() {
        businessService.doProcessing();
    }
}
