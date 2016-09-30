package com.openjml.enhancedForLoopTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.openjml.enhancedForLoop.JMLLazySequence;

public class JMLLazySequenceTest {
	
	private ArrayList<Integer> arr = new ArrayList<Integer>();
	
	
	@Test
	public void testiterator(){
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
		
		Iterator<Integer> it = seq.iterator();
		Iterator<Integer> itr = arr.iterator();
		
		while(it.hasNext()){
			Integer val = it.next();
			System.out.println("next element"+val);
			assertEquals(val,itr.next());
		}
	}
	
	@Test
	public void testget(){
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
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
		
		assertEquals(4,seq.size());
	}

}
