package com.openjml.enhancedForLoop;

import java.lang.Iterable;
import java.util.Iterator;

public class Ones implements Iterable<Integer> {
	
	public Iterator<Integer> iterator(){
		Iterator<Integer> it;
		it = new Iterator<Integer>(){
			
		    public boolean /*@ pure @*/ hasNext() {
		        return true;
		    } 
		    
		    public Integer next() {
		        return 1;
		    }
		};
		return it;
	}

}
