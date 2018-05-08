package com.feivirus.spitest;

import java.util.ServiceLoader;

import com.feivirus.spi.Animal;

public class SpiTest {
    public ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
    
    public void testGetAnimal() {      
        System.out.println("testGetAnimal");
        
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
