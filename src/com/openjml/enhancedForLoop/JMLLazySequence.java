package com.openjml.enhancedForLoop;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class JMLLazySequence<T> implements Iterable<T> {
    private Func1<T> mapping;
    private Iterator<T> iter;
	private ArrayList<T> seen = new ArrayList<T>();
	private Iterable<T> iterable;


    public JMLLazySequence(Iterable<T> it) {
    	iterable = it;
        iter = it.iterator();
       
        mapping =
            new Func1<T>() {
                
                /* Returns the ith element of the iterator associated with it. */
                /*@ requires 0 <= i; 
                  @ assignable seen.objectState; @*/
                public T run(int i) throws IndexOutOfBoundsException {
                    if (seen.size() > i) {
                        return seen.get(i);
                    } else if (seen.size() == i) {
                        if (iter.hasNext()) {
                            seen.add(iter.next());
                            return seen.get(i);
                        } else {
                            throw new IndexOutOfBoundsException();
                        }
                    } else /* if seen.size() < i */ {
                        while (seen.size() <= i) {
                            if (iter.hasNext()) {
                                seen.add(iter.next());
                            } else {
                                throw new IndexOutOfBoundsException();
                            }     
                        }
                        /*@ assert seen.size() == i; @*/
                        return seen.get(i);
                    }
                }
            };
    }

    public void forEach(Consumer<? super T> action) {
        int j = 0;
        try {
            while (true) {
                action.accept(get(j));
                j++;
            }
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }
    
    public Iterator<T> iterator(){
    	
    	Iterator<T> it;
    	it = new Iterator<T>(){
    		int  next_index= 0;
    		boolean done=false;
    		
    		public boolean hasNext(){
    			if(done){
    				return false;
    			}else{
    				if(seen.size()==next_index){
    					return iter.hasNext();
    				}else if(seen.size() > next_index){
    					return true;
    				}else{
    					/*@ assert seen.size() < next_index; @*/
    					while (seen.size() < next_index) {
                            if (iter.hasNext()) {
                                seen.add(iter.next());
                            } else {
                                done = true;
                                return false;
                            }     
                        }
    					/*@ assert seen.size() == next_index; @*/
    					return iter.hasNext();
    				}
    			}
    			
    		}
    		
    		public T next(){
    			T val;
    			val = mapping.run(next_index);
    			next_index++;
    			return val;
    		}
    	};
    
    	return it; 
    	
    }
    
    public T get(int i) throws IndexOutOfBoundsException {
    	
        return mapping.run(i);
    }

    public int size() {
        int i = 0;
        try {
            while (true) {
                mapping.run(i);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            return i;
        }
    }
    
    public JMLLazySequence<T> potential(){
    	return this;
    }
    
    public ArrayList<T> previous(){ 
    	return (ArrayList<T>) (seen.clone());
    }
    
    public int current_index(){
    	return seen.size();
    }
    
  
}
