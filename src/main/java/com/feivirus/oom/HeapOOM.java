package com.feivirus.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feivirus
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 使用 Eclipse memory analyzer分析dump文件
 */
public class HeapOOM {
    static  class  OOMObject {

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
