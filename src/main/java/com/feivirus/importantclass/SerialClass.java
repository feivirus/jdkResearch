package com.feivirus.importantclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化问题
 * @author feivirus
 *
 */
public class SerialClass {
    public static void main (String[] args) {
        File file = new File("/Users/feivirus/Documents/project/sublime/code/java" + File.pathSeparator + "tmp.txt");
        StaticMemberSerial staticMemberSerial = new StaticMemberSerial();        
        staticMemberSerial.setValue(20);
        staticMemberSerial.setStaticInt(5);
       
        SerialClass serialClass = new SerialClass();
        serialClass.writeFile(staticMemberSerial, file);
        
        Object retObj = serialClass.readFile(file);
        StaticMemberSerial retMemberSerial = (StaticMemberSerial)retObj;
        System.out.println(StaticMemberSerial.getStaticInt());
        System.out.println(retMemberSerial.getValue());
    }
    
    public void writeFile(Object object, File file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(object);
            oos.close();            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public Object readFile(File file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}