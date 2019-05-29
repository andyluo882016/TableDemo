package com.app.demo;

public class TreeNode<T extends Comparable<T>> {

	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	T data;
	public TreeNode() {
		super();
		
	}
	
	public TreeNode(T item) {
		this.data=item;
		leftNode=rightNode=null;
		
	}
	
	public void insert(T item) {
		System.out.println(item.toString()+" compare  with root -->  "+data.toString()+"\n result: --> "+item.compareTo(data));
		if (item.compareTo(data) <=0) {
			//leftNode.data=item;
			if (leftNode==null){
				leftNode=new TreeNode<T>(item);
			}
			else
				leftNode.insert(item);
		}
		else if(item.compareTo(data) >0){
			if (rightNode == null) {
				rightNode =new TreeNode<T>(item);
			}
			else
				rightNode.insert(item);
		}
	}
	
	
}
