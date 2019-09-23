package com.feivirus.exam;

public class ReferenceTest {
    public static void main(String[] args) {
        Demo test = null;
        
        Demo.updateRefrence(test);
        System.out.println(test);
        
        Gender gender = Gender.MALE;
        Demo.updateGender(gender);
        System.out.println(gender);       
        
        Demo test1 = new Demo();
        test1.name = "test1";
        Demo.updateRefrence(test1);
        System.out.println(test1.name);
        
        
        Gender gender1 = Gender.MALE;
        gender1 = Gender.FEMALE;
        System.out.println(gender1.getKey());
        
        Integer age = 6;
        Demo.updateInteger(age);
        System.out.println(age);
        
        String name = "feivirus";
        Demo.updateString(name);
        System.out.println(name);
    }    
     
}




enum Gender {
    MALE(0),
    FEMALE(1);
    
    Integer key;
    
    private Gender(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }  
    
}

class Demo {
    public String name;
    
    
    static void updateRefrence(Demo test) {
        test = new Demo();
        test.name = "test";
    }
    
    static void updateGender(Gender gender) {
        gender = Gender.FEMALE;
    }
    
    static void updateInteger(Integer value) {
        value = 10;
    }
    
    static void updateString(String value) {
        value = "updated";
    }
}




