/**
 * 
 */
package com.eci.learning.basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nsingh
 * 
 * "Oracle’s security system generates a log file every hour which holds the entry and exit time of each person entering and exiting the office.
Format of file:
UID        Time       Entry/Exit
1011      9:12:23       Entry 
1563      10:00:25     Entry  
2345      10:34:01     Entry 
4433      10:34:31     Entry 
1011      11:14:35     Exit
1563      11:20:10     Exit
1011      13:00:22     Entry
2345      17:23:40     Exit
…
Can you write a program for a dashboard application that gets updated based on these file feeds on hourly basis and gives the following information:
- Total work hours in that office for a person during a duration or a particular date
- Number of persons in that office during a duration or a particular date
- Number of persons in that office who worked more than 8 hours during a duration or a particular date
Write a program either in java or javascript."

 *
 */
public class PunchTimeCalculationOracle {

	/**
	 * @param args
	 */
	
	private static String file = "C:/Users/nsingh/Desktop/fileToRead.log";
	private static List<TimeDetails> timingList = new ArrayList<TimeDetails>();
	public static void main(String[] args) {
		
		try {
			FileInputStream fStream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
			String strLine;
			int count = -1;
			while((strLine = br.readLine())!=null){
				if (count<0) {count++; continue;}
				//System.out.println(strLine);
				String [] strArr = strLine.replaceAll("\\s+"," ").split(" ");
				//System.out.println(strArr[0]+":"+strArr[1]+":"+strArr[2]);
				timingList.add(new TimeDetails(Integer.valueOf(strArr[0]), strArr[1], strArr[2]));
				
			}
			br.close();
			for(TimeDetails td : timingList){
				System.out.println(td);
			}
			
			for(Map.Entry<Integer, Integer> entry : totalWorkHoursInOfficeForAPerson().entrySet()){
				System.out.println(entry.getKey() +" is hours: "+entry.getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Map<Integer, Integer> totalWorkHoursInOfficeForAPerson(){
		Map<Integer, Integer> retMap = new HashMap<Integer, Integer>();
		Map<Integer, String> timeMap = new HashMap<Integer, String>();
		for(TimeDetails td : timingList){
			if(!retMap.containsKey(td.getuID()) && td.getEntryOrExit().equals("Entry")){
				retMap.put(td.getuID(), 0);
				timeMap.put(td.getuID(), td.getInOutTime());
			}else{
				if(td.getEntryOrExit().equals("Exit")){
					retMap.put(td.getuID(), retMap.get(td.getuID())+timeDiff(timeMap.get(td.getuID()), td.getInOutTime()));
				}
			}
		}
		return retMap;
	}

	public static int timeDiff(String entry, String exit){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date1 = format.parse(entry);
			Date date2 = format.parse(exit);
			long rethr=  date2.getTime() - date1.getTime();
			System.out.println("ret hr: "+rethr);
			return (int)rethr/3600000;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		
		 
		//return 0;
	}

}

class TimeDetails{
	private int uID;
	private String inOutTime;
	private String entryOrExit;
	
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getInOutTime() {
		return inOutTime;
	}
	public void setInOutTime(String inOutTime) {
		this.inOutTime = inOutTime;
	}
	public String getEntryOrExit() {
		return entryOrExit;
	}
	public void setEntryOrExit(String entryOrExit) {
		this.entryOrExit = entryOrExit;
	}
	public TimeDetails(int uID, String inOutTime, String entryOrExit) {
		super();
		this.uID = uID;
		this.inOutTime = inOutTime;
		this.entryOrExit = entryOrExit;
	}
	
	@Override
	public String toString() {
		return "TimeDetails [uID=" + uID + ", inOutTime=" + inOutTime
				+ ", entryOrExit=" + entryOrExit + "]";
	}
	
	
}