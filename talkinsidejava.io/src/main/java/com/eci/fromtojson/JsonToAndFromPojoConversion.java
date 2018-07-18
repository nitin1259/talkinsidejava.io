package com.eci.fromtojson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

/*
 * 
 * https://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 * 
 *	1.1 toJson() – Convert Java object to JSON

	Gson gson = new Gson();
	Staff obj = new Staff();
	
	// 1. Java object to JSON, and save into a file
	gson.toJson(obj, new FileWriter("D:\\file.json"));
	
	// 2. Java object to JSON, and assign to a String
	String jsonInString = gson.toJson(obj);

1.2 fromJson() – Convert JSON to Java object

	Gson gson = new Gson();
	
	// 1. JSON to Java object, read it from a file.
	Staff staff = gson.fromJson(new FileReader("D:\\file.json"), Staff.class);
	
	// 2. JSON to Java object, read it from a Json String.
	String jsonInString = "{'name' : 'mkyong'}";
	Staff staff = gson.fromJson(jsonInString, Staff.class);
	
	// JSON to JsonElement, convert to String later.
	JsonElement json = gson.fromJson(new FileReader("D:\\file.json"), JsonElement.class);
    String result = gson.toJson(json); 
 * 
 */

public class JsonToAndFromPojoConversion {

	public static void convertJavaObjectToJSON(){
		
		Gson gson = new Gson();
		Port port = new Port("port1","port2","port3","port4","port5");
		//try with jre1.7
		/*try (FileWriter writer= new FileWriter("E:\\Desktop\\port.json")){
			gson.toJson(port, writer);
			
			String jsonInString = gson.toJson(port);
			
			System.out.println("Json String: \n "+ jsonInString);
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static void convertJSONToJavaObject(){
		
		Gson gson = new Gson();
		FileReader reader=null;
		try {
			reader = new FileReader("E:\\Desktop\\port.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Port port = gson.fromJson(reader, Port.class);
		
		System.out.println("port: "+port);
	}
	public static void main(String []args){
		convertJavaObjectToJSON();
		System.out.println("other way");
		convertJSONToJavaObject();
	}
}
