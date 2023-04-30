package com.to;

public class Employee {
  private int Eid;
  private String Ename;
  private int Age;
  private String Password;
  
  public  Employee() {
	  
	  
  }

public int getEid() {
	return Eid;
}

public void setEid(int eid) {
	Eid = eid;
}

public String getEname() {
	return Ename;
}

public void setEname(String ename) {
	Ename = ename;
}

public int getAge() {
	return Age;
}

public void setAge(int age) {
	Age = age;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

@Override
public String toString() {
	return "Employee [Eid=" + Eid + ", Ename=" + Ename + ", Age=" + Age + ", Password=" + Password + "]";
}


}
