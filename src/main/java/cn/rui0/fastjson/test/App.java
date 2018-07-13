package cn.rui0.fastjson.test;

import com.alibaba.fastjson.JSON;

/**
 * Created by Ruilin on 2018/5/21.
 */
public class App {
    public static void main(String[] args) {
        Object obj = JSON.parseObject("{\"@type\":\"cn.rui0.fastjson.test.Evil\", \"name\":\"test\",\"age\":\"18\"}");
        System.out.println(obj);
    }
}
