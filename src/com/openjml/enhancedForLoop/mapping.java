package com.openjml.enhancedForLoop;

public class mapping<T> {
    protected /*@ spec_public @*/ boolean computed = false;
    protected /*@ spec_public @*/ T val = null;
    /*@ protected invariant computed ==> val != null; @*/

    protected /*@ spec_public @*/ Func1<T> computation;

    /*@ assignable computation, arg;
      @ ensures computation == f; @*/
    public mapping(Func1<T> f) {
        computation = f;
        
    }

    /*@ assignable val, computed;
      @ ensures \result == computation(arg); @*/
    public synchronized T compute(int i) {
        if (!computed) {
            val = computation.run(i);
            computed = true;
        }
        return val;
    }
}

