package cn.rui0.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ruilin on 2018/7/12.
 */
public class RmiSampleImpl extends UnicastRemoteObject implements RmiSample{
    //覆盖默认构造函数并抛出RemoteException
    public RmiSampleImpl() throws  RemoteException{
        super();
    }
    //所有远程实现方法必须抛出RemoteException
    public int sum(int a,int b) throws  RemoteException{
        return a+b;
    }
}
