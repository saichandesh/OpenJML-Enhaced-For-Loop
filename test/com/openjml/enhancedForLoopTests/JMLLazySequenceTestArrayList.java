package com.openjml.enhancedForLoopTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import com.openjml.enhancedForLoop.JMLLazySequence;

public class JMLLazySequenceTestArrayList {

	private ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4}));
	
	private JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(arr);
	
	@Test
	public void testiterator(){
		Iterator<Integer> it = seq.iterator();
		Iterator<Integer> itr = arr.iterator();
		
		while(it.hasNext()){
			Integer val = it.next();
			assertEquals(val,itr.next());
		}
	}
	
	@Test
	public void testget(){
		Integer exceptedOutput = new Integer(2);
		assertEquals(exceptedOutput,seq.get(1));
	}

	@Test
	public void testsize() {
		assertEquals(4,seq.size());
	}
	
	@Test
	public void testpotential(){
		JMLLazySequence<Integer> seq2 = seq.potential();
		Iterator<Integer> itr1 = arr.iterator();
		Iterator<Integer> itr2 = seq2.iterator();
		Integer exceptedOutput;
		Integer actualOutput;
		
		while(itr1.hasNext() && itr2.hasNext()){
			exceptedOutput = itr1.next();
			actualOutput = itr2.next();
			assertEquals(exceptedOutput,actualOutput);
		}
	}

	@Test
	public void testprevious(){
		Iterator<Integer> itr = seq.iterator();
		int i =0;
		Integer val;
		ArrayList<Integer> previous_seq = seq.previous();
		
		while(itr.hasNext()){
			val = itr.next();
			assertEquals(val,previous_seq.get(i));
			i++;
		}
	}
	
	@Test
	public void testcurrentIndex(){
		Iterator<Integer> itr = seq.iterator();
		int i =0;
		Integer val;
		
		while(itr.hasNext()){
			assertEquals(i,seq.current_index());
			val = itr.next();
			i++;
			assertEquals(i,seq.current_index());
		}
	}

}
