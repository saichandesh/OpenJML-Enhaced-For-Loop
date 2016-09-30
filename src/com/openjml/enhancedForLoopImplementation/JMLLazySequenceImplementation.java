package com.openjml.enhancedForLoopImplementation;

import java.util.ArrayList;
import java.util.Iterator;

import com.openjml.enhancedForLoop.JMLLazySequence;


public class JMLLazySequenceImplementation {

	public static void main(String args[]){
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Integer val;
		
		arr.add(1);
		arr.add(2);
		Iterator<Integer> itr = arr.iterator();
		
		JMLLazySequence<Integer> potential = new JMLLazySequence<Integer>(arr);
	
		ArrayList<Integer> previous = new ArrayList<Integer>();
				
		while(itr.hasNext()){
			val = itr.next();
			previous.add(val);
			System.out.println("Difference : "+ (potential.size() - previous.size()));
		}
		/*@ assert 0 <= previous.size() <= potential.size() @*/
		
		
	}

}
