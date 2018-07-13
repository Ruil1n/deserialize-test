package cn.rui0.test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by Ruilin on 2018/7/9.
 */
public class DeSer{

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.obj"));
        Ser s = (Ser) ois.readObject();
        System.out.println(s.num);
        ois.close();
    }
}
