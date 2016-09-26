package com.openjml.enhancedForLoop;

public interface Func1<T> {
    /*@ assignable objectState; @*/
    T run(int i);
}
