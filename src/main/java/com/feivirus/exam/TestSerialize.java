package com.feivirus.exam;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialize implements Serializable {

    public String name;

    public int id;

    public static void main(String[] args) throws IOException {
        TestSerialize serialize = new TestSerialize();

        ObjectOutputStream stream = new ObjectOutputStream(System.out);
        stream.writeObject(serialize);
    }
}
