package com.openjml.enhancedForLoopTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.openjml.enhancedForLoop.JMLLazySequence;

public class JMLLazySequenceTest {
	
	@Test
	public void testiterator(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
		
		while(seq.iterator().hasNext()){
			assertEquals(seq.iterator().next(),arr.iterator().next());
		}
	}
	
	@Test
	public void testget(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
		
		Integer exceptedOutput = new Integer(2);
		
		assertEquals(exceptedOutput,seq.get(1));
	}

	@Test
	public void testsize() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
		
		assertEquals(4,seq.size());
	}

}
