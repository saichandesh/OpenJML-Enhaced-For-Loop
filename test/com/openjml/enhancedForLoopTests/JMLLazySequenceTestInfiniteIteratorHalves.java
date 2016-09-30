package com.openjml.enhancedForLoopTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.openjml.enhancedForLoop.Halves;
import com.openjml.enhancedForLoop.JMLLazySequence;

public class JMLLazySequenceTestInfiniteIteratorHalves {
	private Halves iterable1 = new Halves();
	private Halves iterable2 = new Halves();
	private JMLLazySequence<Double> seq = new JMLLazySequence<Double>(iterable1);
	
	@Test
	public void testiterator(){
		Iterator<Double> it = seq.iterator();
		Iterator<Double> itr = iterable2.iterator();
		int runloop =4;
		
		while(runloop>0){
			Double val = it.next();
			assertEquals(val,itr.next());
			runloop--;
		}
	}
	
	@Test
	public void testget(){
		Double exceptedOutput = new Double(0.25);
		assertEquals(exceptedOutput,seq.get(2));
	}

	
	@Test
	public void testpotential(){
		JMLLazySequence<Double> seq2 = seq.potential();
		Iterator<Double> itr1 = iterable2.iterator();
		Iterator<Double> itr2 = seq2.iterator();
		Double exceptedOutput;
		Double actualOutput;
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
		Iterator<Double> itr = seq.iterator();
		int i =0, runloop=10;
		Double val;
		ArrayList<Double> previous_seq = seq.previous();
		
		while(itr.hasNext() && runloop>0){
			val = itr.next();
			assertEquals(val,previous_seq.get(i));
			i++;
			runloop--;
		}
	}
	
	@Test
	public void testcurrentIndex(){
		Iterator<Double> itr = seq.iterator();
		int i =0, runloop=10;
		Double val;
		
		while(itr.hasNext() && runloop>0){
			assertEquals(i,seq.current_index());
			val = itr.next();
			i++;
			assertEquals(i,seq.current_index());
			runloop--;
		}
	}

}
