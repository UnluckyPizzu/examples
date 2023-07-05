package com.example.binarystackqueue;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {
	private List<T> stackList;
	
	public Stack() {
		stackList = new LinkedList<T>();
	}
	
	public void push(T object) {
		stackList.add(object);
	}
	
	public boolean isEmpty() {
		return stackList.isEmpty();
	}
	
	public int size() {
		return stackList.size();
	}
	
	public T pop() {
		if (!stackList.isEmpty()) {
			return stackList.remove(size() - 1);
		}
		
		return null;
	}
}
