/**
 * 
 */
package com.eci.learning.basic;

/**
 * @author nsingh
 *
 */

interface Interface1{
	int a=10;
	public void doSomething();
}

interface Interface2 {
	int a = 10;
	public void doSomething();

}



	

public class TestInterface implements Interface1, Interface2{

	/**
	 * @param args
	 */
	int x;
	TestInterface(int n){
		System.out.println(x=n);
	}
	public static void testInterfaceVariable(){
		System.out.println(Interface1.a);
		// error System.out.println(a);
	}
	
	public static void main(String[] args) {
		//testInterfaceVariable();
		
		new TestInterface(2);

	}

	@Override
	public void doSomething() {
		
	}
	
	
	

}
