package cn.rui0.test1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Ruilin on 2018/7/9.
 */
public class Ser implements Serializable{
    private static final long serialVersionUID = 1L;
    public int num=911;
    //重写readObject方法
    private void readObject(java.io.ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();//调用原始的readOject方法
        Runtime.getRuntime().exec("open /Applications/Calculator.app");
        System.out.println("test");
    }
    public static void main(String[] args) {
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.obj"));
//            Ser ser=new Ser();
//            oos.writeObject(ser);//序列化关键函数
//            oos.flush();  //缓冲流
//            oos.close(); //关闭流
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
