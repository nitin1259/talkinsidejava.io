/**
 * 
 */
package com.eci.learning.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author nsingh
 *
 */
public class InnovitiOnlineTest {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> array =
            new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<10000; i++) {
            try {
                array.add(new ArrayList<Integer>(1000000));
            } catch (OutOfMemoryError e) {
                System.out.println(i);
                break;
            }
        }
    }*/
	
	/*public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        int i = 10;
        li.add(10);
        int j = li.get(0);
        System.out.println(j);
    }*/
	
	

    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        Map<String,Integer> retVal = new HashMap<String,Integer>();
        Map<String,Integer> subjetVal = new HashMap<String,Integer>();
        for (String str : array) {
			String[] strArr = str.split(Pattern.quote("|"));
			if (subjetVal.get(strArr[1]) != null) {
				if (subjetVal.get(strArr[1]) <= Integer.valueOf(strArr[2]))

					retVal.put(strArr[1], Integer.valueOf(strArr[0]));
				subjetVal.put(strArr[1], Integer.valueOf(strArr[2]));
			} else {
				subjetVal.put(strArr[1], Integer.valueOf(strArr[2]));
				retVal.put(strArr[1], Integer.valueOf(strArr[0]));
			}
		}
        
       return retVal;
    }

    /*public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("C:/Users/nsingh/Desktop/innoviti/input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/nsingh/Desktop/innoviti/output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }*/
    	

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int i=1,j=1;
        long max=0;
        for(int arr_i=1; arr_i < 5; arr_i++){
            for(int arr_j=1; arr_j < 5; arr_j++){
                long temp = arr[arr_i-1][arr_j-1]+arr[arr_i-1][arr_j]+arr[arr_i-1][arr_j+1]+arr[arr_i][arr_j]+arr[arr_i+1][arr_j-1]+arr[arr_i+1][arr_j]+arr[arr_i+1][arr_j+1];
                if(temp > max){
                    max=temp;
                    i=arr_i;
                    j=arr_j;
                }                   
            }
        }
        System.out.println("max is :"+max);
    }
}


