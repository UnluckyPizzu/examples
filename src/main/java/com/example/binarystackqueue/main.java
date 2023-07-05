package com.example.binarystackqueue;

import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		Comparator<String> comparator = new LengthComparator();
        QueueWithPriority<String> queue = new QueueWithPriority<String>(comparator);

        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");
        queue.enqueue("Date");

        System.out.println("Coda con priorità:");
        while (!queue.isEmpty()) {
            String element = queue.dequeue();
            System.out.println(element);
        }
        
        Stack<String> stack = new Stack<String>();

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        stack.push("Date");

        System.out.println("\nStack:");
        while (!stack.isEmpty()) {
            String element = stack.pop();
            System.out.println(element);
        }
    }
}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}