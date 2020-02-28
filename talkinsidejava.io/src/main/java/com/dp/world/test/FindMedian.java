package com.dp.world.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedian {

	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		
		
		System.out.println("Hello World");
		
		for(int i=0;i<10 ;i++){
		    addNum(i*5);
		    System.out.println(list.toString());
		    System.out.println(findMedian());
		}
		
	}
	
	public static void addNum(int num){
	    list.add(num);
	}
	
	public static double findMedian(){
		if(list.size()==0) return 0;
	    Collections.sort(list);
	    
	    int middle = (int)list.size()/2, median = list.size()%2;
	    // System.out.println(middle);
	    if(median == 0){
	    	
	        return (double)(list.get(middle-1) + (list.get(middle))) /2;
	    }else{
	        return list.get(middle);
	    }
	}

}
