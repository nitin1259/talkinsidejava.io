/**
 * 
 */
package com.eci.spring.setter.depen;

/**
 * @author nsingh
 *
 */
public class ConcreteAnswer {

	private boolean isRight;

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	@Override
	public String toString() {
		return "ConcreteAnswer [isRight=" + isRight + "]";
	}
	
	
}
