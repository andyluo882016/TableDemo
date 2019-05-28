package com.app.demo;
import com.app.Employee;
public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Employee e= new  Employee(100, "Ninja Panda", 28907.219); 
	      Employee e1= new  Employee(101, "Julie Smith", 8976541.897); 
	      Employee e2= new  Employee(102, "Gaery Dick", 6758.219); 
	      Employee e3= new  Employee(103, "Keven Oliver", 18907.219); 
	      Employee e4= new  Employee(104, "ilise  Oliver", 8907.219); 
	      
	      LinkedList<Employee> list=new LinkedList<Employee>();
	      LinkedList<Employee> list1=new LinkedList<Employee>("test", e2);
	      //list1.firstNode.print();
	      //list1.print();
	      System.out.println("----------step1");
	      list.insertNode(e);
	     // System.out.println("----------step2");
	      list.insertNode(e4);
	      
	    //  System.out.println("----------step3\n");
	      list.insertNode(e3);
	      list.insertNode(e2);
	      //list.print();
	      System.out.println("----------step4\n");
	     //list.deletedNode(e);
	      list.print();
	      System.out.println("----------step5\n");
	      list.deletedNode(e);
	      System.out.println("----------step6\n");
	      list.print();
	      //list.print2();
	      

	}

}
