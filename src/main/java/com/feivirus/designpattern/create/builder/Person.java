package com.feivirus.designpattern.create.builder;

/**
 *
 * @author feivirus
 *
 */

public class Person {
    private String  name;
    private Integer age;
    private String  address;
    private String  email;
    
    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        address = builder.address;
        email = builder.email;
    }    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {        
        private String  name;
        private Integer age;
        private String  address;
        private String  email;
        
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }
        
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }    
        
        public Person build() {        
            return new Person(this);
        }
    }
}
