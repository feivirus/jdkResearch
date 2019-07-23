package com.feivirus.exam;

import static org.hamcrest.CoreMatchers.not;

import java.util.BitSet;

public class TestBitSet {
    
    public static void main(String [] args) {
        int count = 100;
        BitSet bitSet = new BitSet(count + 1);
        int i;
        for (i = 0; i < count; i++) {
            bitSet.set(i);
        }
        
       for (i = 0; i < count; i++) {
           if (i % 2 == 0) {
             bitSet.clear(i);
           }
        }
           
      for(i = 0 ; i < bitSet.length(); i++) {
          System.out.println(i + " " + bitSet.get(i));
      }
       
    }
        
    
}
