package com.feivirus.javatool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feivirus
 * jconsole 命令,直接出来界面操作
 */
public class JConsoleTest {
    static class OOMObject {
        public byte[] _64K = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws Exception {
        List<OOMObject> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) {
        try {
            fillHeap(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
