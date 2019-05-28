package com.app.demo;

public class EmptyNodeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6224224309321090327L;

	public EmptyNodeException(){
		this("list");
	}
	
	public EmptyNodeException(String m) {
		super(m + " this is empty ");
	}
}
