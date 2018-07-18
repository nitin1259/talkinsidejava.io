/**
 * 
 */
package com.eci.spring.basic.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author nsingh
 *
 */
@Component
@Aspect
public class LogabbleAspect{
	
	@Before("logAddPointCut() || getAnnotationPointCut()")
	public void logAdvice(){
		System.out.println("happening before add/annotate multiply method");
	}
	
	@After("logAddPointCut()")
	public void logAfterAdvice(){
		System.out.println("happening after add method");
	}
	
	@Pointcut("execution(* *.add(..))")
	public void logAddPointCut(){}
	
	@Pointcut("execution(* *.division())")
	public void logDividePointCut(){}
	
	@Pointcut("execution(* *.division(..))")
	public void logParamDividePointCut(){}
	
	@AfterReturning(pointcut="logAddPointCut() || logDividePointCut() || logParamDividePointCut()")
	public void logAfterReturningAdvice(JoinPoint joinPoint){
		System.out.println("coming in after returning 1st line");
		ArithmeticOp arithmetic = (ArithmeticOp)joinPoint.getTarget();
		arithmetic.multiply(10, 0);
		arithmetic.division(10, 2);
		System.out.println("This is in after returning");
	}
	
	@AfterThrowing(pointcut="logParamDividePointCut() && target(arithmetic)", throwing="exception" )
	public void logAfterThrowingAdvice(Throwable exception, ArithmeticOp arithmetic){
		System.out.println("in throwing excp: "+ arithmetic.add(100, 134));
		System.out.println("This is in after Throwing exception: " +exception.getMessage());
	}
	
	
	@Pointcut("@annotation(LoggableAnnotation)")
	public void getAnnotationPointCut(){}

}
