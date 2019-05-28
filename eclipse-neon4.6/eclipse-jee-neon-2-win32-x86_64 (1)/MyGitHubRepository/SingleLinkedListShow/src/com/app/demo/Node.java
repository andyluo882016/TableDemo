package com.app.demo;

public class Node<T> {

	 T data;
	Node<T> nextNode;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNextNode() {
		if (nextNode == null) {
			System.out.println("nextNode is null");
			//T t=null;
			return new Node<T>();
		}
		
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	@Override
	public String toString() {
		return "Node [**->data=" + data + ", nextNode=" + nextNode + "]";
	}
	
	public String print(){
		return "this is empty node --> with data: "+ data.toString();
	}
	
	public Node(T data, Node<T> nextNode) {
		super();
		this.data = data;
		this.nextNode = nextNode;
	}
	public Node(T data) {
		this(data, null);
	}
	
	public Node(){
		System.out.println("empty Node");
	}
	
	
	
	
}
