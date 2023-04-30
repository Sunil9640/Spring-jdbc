package com.main;

import java.util.List;

import com.dao.EmployeeDAO;
import com.to.Employee;
public class Main {
	public static void main(String args[]) {
	ApplicationContex ap =new ClassPathXmlApplicationContex ("bean.xml");
    EmployeeDAO dao=(EmployeeDAO)ap.getBean("edao");
    Employee e1=new Employee();
    e1.setEid(103);
    e1.setEname("r");
    e1.setAge(40);
    e1.setPassword("yuu");
    int count=dao.addEmployee(e1);
    System.out.println(count+"record added");
    
	}

}
