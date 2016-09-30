package com.openjml.enhancedForLoop;

import java.util.Iterator;

public class Halves implements Iterable<Double> {
    private /*@ spec_public @*/ double last = 2.0;
	
	public Iterator<Double> iterator(){
		Iterator<Double> it;
		it = new Iterator<Double>(){
			
		    public boolean /*@ pure @*/ hasNext() {
		        return true;
		    } 
		    
		    /*@ assignable last;
		      @ ensures last == \old(last*0.5) && \result == last;
		      @*/
		    public Double next() {
		        last *= 0.5;
		        return last;
		    }
		};
		return it;
	}
    
}
