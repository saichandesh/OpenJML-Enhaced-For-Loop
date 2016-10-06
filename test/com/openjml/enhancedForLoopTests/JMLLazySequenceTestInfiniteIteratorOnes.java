package com.openjml.enhancedForLoopTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.openjml.enhancedForLoop.JMLLazySequence;
import com.openjml.enhancedForLoop.Ones;

public class JMLLazySequenceTestInfiniteIteratorOnes {
	
	private Ones iterable1 = new Ones();
	private Ones iterable2 = new Ones();
	private JMLLazySequence<Integer> seq = new JMLLazySequence<Integer>(iterable1);
	
	@Test
	public void testiterator(){
		Iterator<Integer> it = seq.iterator();
		Iterator<Integer> itr = iterable2.iterator();
		int runloop =10;
		
		while(runloop>0){
			Integer val = it.next();
			assertEquals(val,itr.next());
			runloop--;
		}
	}
	
	@Test
	public void testget(){
		Integer exceptedOutput = new Integer(1);
		assertEquals(exceptedOutput,seq.get(1));
	}

	
	@Test
	public void testpotential(){
		JMLLazySequence<Integer> seq2 = seq.potential();
		Iterator<Integer> itr1 = iterable2.iterator();
		Iterator<Integer> itr2 = seq2.iterator();
		Integer exceptedOutput;
		Integer actualOutput;
		int runloop =10;
		
		while(itr1.hasNext() && itr2.hasNext() && runloop>0){
			exceptedOutput = itr1.next();
			actualOutput = itr2.next();
			assertEquals(exceptedOutput,actualOutput);
			runloop--;
		}
	}

	@Test
	public void testprevious(){
		Iterator<Integer> itr = seq.iterator();
		int i =0, runloop=10;
		Integer val;
		ArrayList<Integer> previous_seq = seq.previous();
		
		while(itr.hasNext() && runloop>0){
			val = itr.next();
			assertEquals(val,previous_seq.get(i));
			i++;
			runloop--;
		}
	}
	
	@Test
	public void testcurrentIndex(){
		Iterator<Integer> itr = seq.iterator();
		int i =0, runloop=10;
		Integer val;
		
		while(itr.hasNext() && runloop>0){
			assertEquals(i,seq.current_index());
			val = itr.next();
			i++;
			assertEquals(i,seq.current_index());
			runloop--;
		}
	}
}
