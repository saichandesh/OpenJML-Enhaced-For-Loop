package com.openjml.enhancedForLoop;

import java.util.Iterator;

public class Halves implements Iterator<Double> {

    private /*@ spec_public @*/ double last = 2.0;
    
    public boolean /*@ pure @*/ hasNext() {
        return true;
    }

    /*@ assignable last;
      @ ensures last == \old(last*0.5) && \result == last;
      @*/
    public Double next() {
        last *= 0.5;
        System.out.println("returning " + last + " from Halves.next");
        return last;
    }
}
