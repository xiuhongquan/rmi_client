package com.example.demo.rpc_rmi.service;

import java.util.List;

public interface EmpService {

    public List<String> findAllEmp();
    public List<String> findEmpByName(String ename);
}
