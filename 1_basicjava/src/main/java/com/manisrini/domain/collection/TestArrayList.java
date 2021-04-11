package com.manisrini.domain.collection;

/*
 * In ArrayList, Enumeration is fast.
 * orderd by insertion order because it's a dynamic array
 * random access=yes because get method
 * allows null=yes
 */
import java.util.ArrayList;

import com.manisrini.domain.Employee;


public class TestArrayList {


	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setEmployeeId(1);
		emp1.setEmployeeName("Suganthi");
		Employee emp2 = new Employee();
		emp2.setEmployeeId(2);
		emp2.setEmployeeName("Mani");
		Employee emp3 = new Employee();
		emp3.setEmployeeId(3);
		emp3.setEmployeeName("Srinivasan");
		Employee emp4 = new Employee();
		emp4.setEmployeeId(4);
		emp4.setEmployeeName("Parvadham");
		
		ArrayList<Employee> aList=  new ArrayList<Employee>();
		aList.add(emp4);
		aList.add(emp3);
		aList.add(emp2);
		aList.add(emp1);
		//aList.add(null);//when you read null pointer exception will be raised
		//aList.add(10, emp2);//when you read Indexoutofboundexception will be raised
		
		for (Employee employee : aList) {
			System.err.println("Employee number=>"+employee.getEmployeeId());
		}
		for(int i=0;i<aList.size();i++){
			Employee employee = (Employee)aList.get(i);
			System.err.println("Employee number=>"+employee.getEmployeeId());
		}
		//System.err.println("List==>"+aList);
	}

}
