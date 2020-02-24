package com.feivirus.spi;

import java.util.ServiceLoader;

public class SpiTest {
    public void testGetAnimal() {      
        System.out.println("testGetAnimal");

        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);

        if (serviceLoader == null) {
            System.out.println("spi 发现 0 个实现");
            return;
        }
        for(Animal animalItem : serviceLoader) {
            System.out.println(animalItem.getName());
        }
        
    }
    
    public static void main(String[] args) {
        SpiTest spiTest = new SpiTest();
        
        spiTest.testGetAnimal();
    }
}
