package cn.rui0.RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Ruilin on 2018/7/12.
 */
public class RmiSampleClient {
    public static void main(String[] args)
    {
        try {
            String url =  "//localhost:8808/SAMPLE-SERVER";
            RmiSample RmiObject =  (RmiSample) Naming.lookup(url);
            System.out.println(" 1 + 2 =  " + RmiObject.sum(1,2) );
        } catch (RemoteException exc) {
            System.out.println("Error  in lookup: " + exc.toString());
        } catch (java.net.MalformedURLException exc) {
            System.out.println("Malformed URL: " + exc.toString());
        } catch (java.rmi.NotBoundException exc) {
            System.out.println("NotBound:  " + exc.toString());
        }
    }
}
