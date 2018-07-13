package cn.rui0.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Ruilin on 2018/7/12.
 */
//远程接口
public interface RmiSample extends Remote {
    public  int sum(int a,int b) throws RemoteException;

}
