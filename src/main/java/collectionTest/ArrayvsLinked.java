package collectionTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exception.ExceptionMinCaloryFilterLessZero;

public class ArrayvsLinked {
	private static final int NUM_ELEMENTS = 10000;
	
	/**
	* 
	* method of compare LinkedList and ArrayList
	*/
	public static void compare() {
		List ar = new ArrayList();
		for (int i = 0; i < NUM_ELEMENTS; i++) {
			ar.add(i);
		}
		testList(ar);
		testList(new LinkedList(ar));
		  }
	
	
	/**
	* 
	* method of test LinkedList and ArrayList
	*/
	public static void testList(List list) {
	    long time = System.currentTimeMillis();
	    for (int i = 0; i < 10000; i++) {
	      list.add(NUM_ELEMENTS / 2, new Object());
	      list.remove(NUM_ELEMENTS / 2);
	    }
	    time = System.currentTimeMillis() - time;
	    System.out.println(list.getClass().getSimpleName() + " took " + time);
	  }
	  
}
