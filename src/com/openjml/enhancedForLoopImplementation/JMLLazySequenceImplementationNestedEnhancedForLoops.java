package com.openjml.enhancedForLoopImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.openjml.enhancedForLoop.JMLLazySequence;

public class JMLLazySequenceImplementationNestedEnhancedForLoops {

	private static ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4}));
	private static ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(new Integer[] {100,200,300}));

	public static void main(String args[]){
		
		System.out.println("Enhanced For Loop for java");
		
		for(Integer val1: arr1){
			System.out.println("Value in the arr1 : "+ val1);
			for(Integer val2: arr2){
				System.out.println("Value in the arr2: "+ val2);
			}
		}
		
		System.out.println("---------------------------------------------");
		System.out.println("-----Desugar the nested enhanced for loop----");
		System.out.println("---------------------------------------------");
		
		JMLLazySequence<Integer> seq1 = new JMLLazySequence<>(arr1);
		/*@ maintaining seq1.potential(), seq1.previous(), seq1.current_index();
		  @ decreasing seq1.potential().size() - seq1.previous().size();
		  @*/
		Iterator<Integer> iter1 = seq1.iterator();
		Integer val1, val2;
		
		while(iter1.hasNext()){
			val1 = iter1.next();
			System.out.println("Value in the arr1 : "+ val1);
			JMLLazySequence<Integer> seq2 = new JMLLazySequence<>(arr2);
			/*@ maintaining seq2.potential(), seq2.previous(), seq2.current_index();
			  @ decreasing seq2.potential().size() - seq2.previous().size();
			  @*/
			Iterator<Integer> iter2 = seq2.iterator();
			while(iter2.hasNext()){
				val2 = iter2.next();
				System.out.println("Value in the arr2: "+ val2);
			}
		}
		
	}

}
