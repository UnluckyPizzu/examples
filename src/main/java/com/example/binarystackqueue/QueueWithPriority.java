package com.example.binarystackqueue;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueWithPriority<T> {
	private List<T> queueList;
	private Comparator<T> comparator;

	
	public QueueWithPriority(Comparator<T> comparator) {
		queueList = new LinkedList<T>();
		this.comparator = comparator;
	}
	
	public void enqueue(T object) {
		queueList.add(object);
		Collections.sort(queueList, comparator);
	}
	
	public boolean isEmpty() {
		return queueList.isEmpty();
	}
	
	public int size() {
		return queueList.size();
	}
	
	public T dequeue() {
		if (!queueList.isEmpty()) {
			return queueList.remove(0);
		}		
		return null;
	}
}