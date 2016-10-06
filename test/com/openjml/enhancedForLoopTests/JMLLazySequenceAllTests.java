package com.openjml.enhancedForLoopTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JMLLazySequenceTestArrayList.class, JMLLazySequenceTestInfiniteIteratorHalves.class,
		JMLLazySequenceTestInfiniteIteratorOnes.class })
public class JMLLazySequenceAllTests {

	public static void main(String[] args) {
		
	}

}
