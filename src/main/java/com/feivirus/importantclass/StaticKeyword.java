package com.feivirus.importantclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author feivirus
 * 参考链接:
 * 
 */
public class StaticKeyword {
    public void testLocal() {
        Integer value = 10;
    }

    public static void main(String[] args) {
        List<UserDemo> userDemoList = new ArrayList<>();
        UserDemo a = new StaticKeyword.UserDemo();
        a.setName("a");
        UserDemo b = new StaticKeyword.UserDemo();
        b.setName("b");

        userDemoList.add(a);
        userDemoList.add(b);

        userDemoList.forEach( userDemo -> {
            System.out.println(userDemo.getName());
        });

        System.out.println("------");

        UserDemo c = a;
        c.setName("c");
        userDemoList.forEach( userDemo -> {
            System.out.println(userDemo.getName());
        });
    }

    static class UserDemo {
        private String name;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
