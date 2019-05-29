package com.app.demo;

public class balanceTree <T extends Comparable<T>> {

	TreeNode<T> root;
	String name;
	
	balanceTree(){
		this.root=null;
		this.name="Balance Tree";
	}
	
	public void insertTree(T item){
		if (root==null) {
			root=new TreeNode<T>(item);
		}
		else
		 root.insert(item);
	}
	
	public void preorder(){
		System.out.println("tree name: "+this.name);
		preorderHelps(root);
	}
	
	
	public void preorderHelps(TreeNode<T> node) {
		
		if (node==null) {
			return;
		}
		else {
			System.out.printf("%s ", node.data);
			preorderHelps(node.leftNode);
			preorderHelps(node.rightNode);
		}
	}
	
	public void inorderTraversal(){
		System.out.println("tree name: "+this.name);
		inorderHelper( root );
	}
	private void inorderHelper( TreeNode< T > node ){
		if ( node == null )
			return;
		inorderHelper( node.leftNode );
		System.out.printf( "%s ", node.data );
		inorderHelper( node.rightNode );
	}
}
