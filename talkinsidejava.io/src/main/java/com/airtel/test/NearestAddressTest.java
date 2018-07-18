/**
 * 
 */
package com.airtel.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nsingh
 *
 */
public class NearestAddressTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*List<Address> addList = new ArrayList<Address>();

		Address add1 = new Address("6480", "Sector C6", "Vasant Kunj");
		Address add2 = new Address("Plot 16", "Udyog Vihar Phase-4", "Gurgaon");
		Address add3 = new Address("8231", "Sector C8", "Vasant Kunj");
		Address add4 = new Address("C-6/6280", "Vasant Kunj", "");

		addList.add(add1);
		addList.add(add2);
		addList.add(add3);
		addList.add(add4);
		
		Address nearAddress1 =  new Address("6279", "Sector C6", "Vasant Kunj");

		Address nearAddress2 =  new Address("Plot 18", "Sector C6", "Vasant Kunj");*/
		
		List<String> addList = new ArrayList<>();

		addList.add("6480, Sector C6, Vasant Kunj");
		addList.add("Plot 16, Udyog Vihar Phase-4, Gurgaon");
		addList.add("8231, Sector C8, Vasant Kunj");
		addList.add("C-6/6280, Vasant Kunj");

		
		System.out.println("nearest: "+ getNearestAddress(addList, "6279, Sector c6, Vasant Kunj"));
		System.out.println("nearest: "+ getNearestAddress(addList, "Plot 18, National Hiway 8, udyog Vihar, Gurgaon"));
		
		
	}

	
	public static String getNearestAddress(List<String> addressList, String findAddress){
		int min = Integer.MAX_VALUE;
		String returnAdd=null;
		for(String str : addressList){
			if(str.substring(str.lastIndexOf(",")) != findAddress.substring(findAddress.lastIndexOf(",")))
				continue;
			else{
				int disDif = differenceOfAddress(str, findAddress);
			
			//int disDif = levenshtein_Distance(str, findAddress);
			//System.out.println("index: "+indexdif);
			if(disDif<min) {min = disDif; returnAdd =str;}
			}
		}
		
		return returnAdd;
	}
	
	
	public static int levenshtein_Distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
	
	
	private static int differenceOfAddress(String str, String findadd) {
	    String [] add1 = str.split(",|/");
	    String [] add2 = findadd.split(",|/");
	    int l1 = add1.length-1, l2= add2.length-1;
	    int lenth = (l1<l2)?l1:l2;
	    int sum=0;
	    for(int i=0; i<lenth;i++){
	    	System.out.println("add1: "+add1[i].replace("-", "") +" add2: "+ add2[i].replace("-", ""));
	    	if(str.contains(add2[i].replace("-", "")) || findadd.contains(add1[i].replace("-", "")))continue;
	    	sum=sum+levenshtein_Distance(add1[i].replace("-", ""),add2[i].replace("-", ""));
	    }
	    
	    System.out.println("sum is: "+sum);
	    return sum;
		
	}
	
}
