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
	     // System.out.println(e.compareTo(e1));
	      balanceTree<Employee> btree=new balanceTree<Employee>();
	      
	      btree.insertTree(e);
	      btree.insertTree(e4);
	      btree.insertTree(e3);
	      btree.insertTree(e1);
	      System.out.println("----\n");
	      btree.preorder();
	      System.out.println("\n----------------\n");
	      btree.inorderTraversal();
	}

}
