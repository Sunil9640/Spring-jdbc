package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.to.Employee;

public class EmployeeDAO {
	private static final PlatformTransactionManager PlatformTransactionManger = null;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager platformTransactionManager;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource =dataSource;
		jdbcTemplate=new JdbcTemplate(this.dataSource);
		
	}
	
	public int addEmployee(Employee e) {
		int count =0;
		String query ="insert into employee values(?,?,?,?)";
		count=jdbcTemplate.update(query,e.getEid(),e.getEname(),e.getAge(),e.getPassword());
		return count;
	}
	public List<Employee> getAllEmployees(){
		String sql="select * from employee";
		
		@SuppressWarnings("unchecked")
		List<Employee>listemp=jdbcTemplate.query(sql,new EmployeeMapper());
		return listemp;
		
	}
     public List<Employee>getAllEmployeeOnAge(int age){
    	 String sql="select * from employee where age=?";
    	 @SuppressWarnings("unchecked")
    	 List<Employee> listemp=jdbcTemplate.query(sql,new EmployeeMapper(),age);
    	 return listemp;
    	 
     }
     public void performMultiActions(Employee e) {
    	 System.out.println();
    	 System.out.println("performing Multiple Actions");
    	 TransactionDefinition td =new DefaultTransactionDefinition();
    	 TransactionStatus ts =platformTransactionManager.getTransaction(td);
    	 try {
    		 String query ="insert into employee values(?,?,?,?)";
    		 int count=jdbcTemplate.update(query,e.getEid(),e.getEname(),e.getAge(),e.getPassword());
    		 System.out.println(count+"Records inserted");
    		 String sql="select * from employee where Age=(select max(Age) from employee)";
    		 List<Employee> a=jdbcTemplate.query(sql, new EmployeeMapper());
    		 System.out.println("max age="+a);
    		 platformTransactionManager.commit(ts); 
    	 }
    	 catch(Exception ex) {
    		 System.out.println("Transaction Failed"+ex);
    		 platformTransactionManager.rollback(ts);
    		 
    	 }
     }
     public JdbcTemplate getJdbcTemplate() {
    	 return jdbcTemplate;
    	 
     }
     public void setJdbcTemplate(JdbcTemplate jdbcTemplate ) {
    	 this.jdbcTemplate=jdbcTemplate;
    	 
     }
     public PlatformTransactionManager getPlatformTransactionManger() {
    	 return PlatformTransactionManger;
     }
     public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
    	 this.platformTransactionManager=PlatformTransactionManger;
     }
}
