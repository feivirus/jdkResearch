package com.feivirus.javatool;

public class JstackTest {
    private Double count = 1000d;
    
    public Double getCount() {
        return count;
    }
    
    public static void main(String[] args) {      
        JstackTest test = new JstackTest();
        
        for (int i = 0; i < test.getCount(); i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
