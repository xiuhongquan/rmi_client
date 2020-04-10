package com.example.demo.rpc_rmi.service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RmiClient {
    public static void main(String[] args) {
        try {
            // 获取服务注册管理器 （传入服务器的：地址和端口）
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
            /**
             * 根据命名获取服务 根据startServer的registry.rebind("EmpService", es);
             * 绑定的名字来找到 对应es的对象的代理对象==我们操作代理对象的时候-底层会发送网络请求给server=执行es真实对象的
             * 对应的方法
             */
            EmpService empService = (EmpService) registry.lookup("EmpService");
            System.out.println("代理对象：" + empService.getClass());
            //使用代理对象=调用远程方法
            List<String> listName =empService .findEmpByName("周");
            System.out.println("远程方法结果：" + listName );
            //等待
            System.in.read();
        } catch (Exception e) {
            System.out.println("使用远程调用服务失败");
            e.printStackTrace(System.out);
        }
    }
}
