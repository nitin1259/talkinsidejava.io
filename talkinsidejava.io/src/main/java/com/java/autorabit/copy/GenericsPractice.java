/**
 * 
 */
package com.java.autorabit.copy;

/**
 * @author nisingh
 *
 */
public class GenericsPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Generic Method Test
		/*
		Integer [] intArr = {1,2,3,4,5,6};
		Double [] doubleArr = {1.2,2.3,3.4,4.5,5.6};
		String [] strArr = {"Amit","Deepak", "Pawan", "Rahul","Tejyan"};
		
		GenericMethodTest.printGenericsArray(intArr);
		GenericMethodTest.printGenericsArray(doubleArr);
		GenericMethodTest.printGenericsArray(strArr);
		*/
		
		//Generic Bound type test for 
		/* 
		System.out.printf("Max of %d, %d and %d is %d\n\n", 
		     3, 4, 5, GenericBoundTypeFindMax.findMax( 3, 4, 5 ));
		
		  System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
		     6.6, 8.8, 7.7, GenericBoundTypeFindMax.findMax( 6.6, 8.8, 7.7 ));
		
		  System.out.printf("Max of %s, %s and %s is %s\n","pear",
		 "apple", "orange", GenericBoundTypeFindMax.findMax("pear", "apple", "orange"));
		  */
		
		  // Generics input test to calculate sum
		  System.out.println(GenericInputTest.calcSum(3, 3.5));
		  System.out.println(GenericInputTest.calcSum(5.543, 1));
		  
	}

}


class GenericMethodTest {
	
	
	public static <E> void printGenericsArray(E[] input) {
		
		for (E ele: input) {
			System.out.printf(" %s ", ele);
		}
		
		System.out.println();
	}
}

class GenericBoundTypeFindMax {
	
	public static <T extends Comparable<T>> T findMax(T x, T y, T z) {
		T max = x;
		
		if(y.compareTo(max)>0) max=y;
		if(z.compareTo(max)>0) max=z;
		
		return max;
	}
	
}

class GenericInputTest{
	
	public static <T extends Number> double calcSum(T x, T y) {
		return  x.doubleValue() + y.doubleValue();
		
	}
}

class GenericUpperBoundTest{
	
	
}


