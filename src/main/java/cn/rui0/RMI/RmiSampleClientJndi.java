package cn.rui0.RMI;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by Ruilin on 2018/7/12.
 */
public class RmiSampleClientJndi {
    public static void main(String[] args) throws Exception
    {
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL,"rmi://localhost:8808");
        InitialContext ctx=new InitialContext();
        String url =  "java:comp/env/SampleDemo";
        RmiSample RmiObject  = (RmiSample)ctx.lookup(url);
        System.out.println("  1 + 2 = " + RmiObject.sum(1,2) );

    }
}
