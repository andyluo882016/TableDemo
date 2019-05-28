package com.app.demo;

import com.app.demo.Node;

public class LinkedList<T> {

	 Node<T> firstNode;
	 String name;
	
	LinkedList(){
		this("This is LinkedList");
		System.out.println("create a LinkedList");
	}
	
	LinkedList(String n) {
		this.name=n;
		firstNode=null;
	}
	
	LinkedList(String n, T t) {
		this.name=n;
		firstNode=new Node<T>(t);
		System.out.println("%%%%  "+firstNode.getData().toString());
	}
	
	public void insertNode(T data) {
		
		if (firstNode ==null){
			this.firstNode=new Node<T>(data);
			//System.out.println("^^^-"+firstNode.getData().toString());
		}
		else {
		  firstNode =new Node<T>(data, firstNode);
		//System.out.println("++--"+firstNode.getData().toString());
		}
		
	}
	
	public boolean isEmpty(){
		if (firstNode ==null) {
			System.out.println("This is empty node");
		}
		return firstNode==null;
	}
	
	public void print() throws EmptyNodeException{
		if (isEmpty()) {
			throw new EmptyNodeException(name);
		}
		Node<T> current =firstNode;
		while(current !=null) {
			
			System.out.println("--===  \n"+current.data);
			 current =current.nextNode;
			//firstNode.nextNode=null; -- if use this statement then will remove all nextNode
			
		}
		System.out.println();
	}
	
	
	
	public void deletedNode(T t) throws EmptyNodeException{
	if (isEmpty()) {
		throw new EmptyNodeException(name);
	}
	Node<T> current=firstNode;
	
	LinkedList<T> getNode=new LinkedList<T>("test");
	
	int c=0;
	while(current!=null) {
		current=current.nextNode;
		c++;
		if (!(current.data).equals(t)){
			getNode.insertNode(current.data);
			System.out.println("[ "+c+" ]\ncurrent nextNode data --+++ >"+current.getData());
		}
		firstNode.nextNode=null;  //this statement will remove each nextNodeuntil hit the key
		if ((current.data).equals(t)) {
			System.out.println(" ["+c+" ]\nfound the match current data -->"+current.getData());
			current=current.nextNode=null;  //stop the while loop
		}
		
	
	}

	System.out.println("\n----- the getnode: --- \n");
	firstNode.nextNode=getNode.firstNode;
	System.out.println(firstNode.toString());

	System.out.println("----------------- \n");
}
}
