package com.feivirus.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feivirus
 * -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
 */
public class MemoryLeakTest {
    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof  Key) {
//                if(((Key)obj).id.equals(this.id)) {
//                    return true;
//                }
//            }
//            return false;
//        }
    }

    public static void main(String[] args) {
        Map m = new HashMap();

        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "number " + i);
                }
            }

            System.out.println("m size " + m.size());
        }
    }
}
