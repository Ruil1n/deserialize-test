package cn.rui0.RMI;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Ruilin on 2018/7/12.
 */
public class RmiSampleServerJndi {
    public  static void main(String[] args) throws Exception{

        LocateRegistry.createRegistry(8808);
        RmiSampleImpl  server=new RmiSampleImpl();
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL,"rmi://localhost:8808");
        InitialContext ctx=new InitialContext();
        ctx.bind("java:comp/env/SampleDemo",server);
        ctx.close();

    }
}
