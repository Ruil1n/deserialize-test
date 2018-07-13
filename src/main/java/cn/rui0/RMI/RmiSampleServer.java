package cn.rui0.RMI;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Ruilin on 2018/7/12.
 */
//服务类
public class RmiSampleServer {
    public static void main(String[] args) {
        /*创建和安装一个安全管理器，令其支持RMI.作为Java开发包的一部分
            *适用于RMI唯一一个是RMISecurityManager.
            *
           if(System.getSecurityManager() == null) {
              System.setSecurityManager(new  RMISecurityManager());
            }
        */
        try {
            LocateRegistry.createRegistry(8808);
            RmiSampleImpl server = new RmiSampleImpl();
            Naming.rebind("//localhost:8808/SAMPLE-SERVER", server);
            System.out.println("远程对象注册成功，RMI服务已经启动，等待客户端调用....");
        } catch (java.net.MalformedURLException me) {
            System.out.println("Malformed URL:" + me.toString());
        } catch (RemoteException re) {
            System.out.println("Remote exception:" + re.toString());
        }
    }
}
//将远程对象名字绑定到对远程对象的引用上：

//LocateRegistry.createRegistry(8808);指定本RMI服务程序不使用默认端口1099,而是使用自己指定的端口8808。

//Naming.rebind("//localhost:8808/SAMPLE-SERVER" , Server);将远程对象在服务器上注册并指定了将查找远程对象引用的URL，URL格式为//host:port/name。其中 host 是注册表所在的主机（远程或本地），port 是注册表接受调用的端口号，name 是未经注册表解释的简单字符串。host 和 port 两者都是可选项。如果省略了 host，则主机默认为本地主机。如果省略了 port，则端口默认为 1099，该端口是 RMI 的注册表 rmiregistry 使用的“著名”端口。