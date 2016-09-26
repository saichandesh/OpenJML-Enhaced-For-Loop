package com.openjml.enhancedForLoop;

import java.util.Iterator;

public class Ones implements Iterator<Integer> {
    public boolean /*@ pure @*/ hasNext() {
        return true;
    }

    public Integer next() {
        System.out.println("returning 1 from Ones.next");
        return 1;
    }
}
