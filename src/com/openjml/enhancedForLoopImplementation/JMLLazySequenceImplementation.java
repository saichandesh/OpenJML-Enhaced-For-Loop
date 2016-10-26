package com.openjml.enhancedForLoopImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.openjml.enhancedForLoop.JMLLazySequence;


public class JMLLazySequenceImplementation {
	
	private static ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4}));

	public static void main(String args[]){
		
		System.out.println("Enhanced For Loop for java");
		
		for(Integer val: arr){
			System.out.println("Value in the list: "+ val);
		}
		
		System.out.println("---------------------------------------------");
		System.out.println("------Desugar the enhanced for loop----------");
		System.out.println("---------------------------------------------");
		
		JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
		/*@ maintaining seq.potential(), seq.previous(), seq.current_index();
		  @ decreasing seq.potential().size() - seq.previous().size();
		  @*/
		Iterator<Integer> iter = seq.iterator();
		Integer val;
		
		while(iter.hasNext()){
			val = iter.next();
			System.out.println("Value in the list: "+ val);
		}
		
	}

}
