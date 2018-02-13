package us.csbu.cs540.finalexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Car implements Cloneable { 
	private Tyre tyres[] = new Tyre[4]; 

	public Car() { 
		for (int i=0; i<4; i++){
			tyres[i] = new Tyre();
		}
	}
	
	public Object clone() throws CloneNotSupportedException { 
		Car c = new Car(); 	
		c.tyres = this.tyres;
		return c;
	}
	
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		for(String obj : strList){
		    System.out.println(obj);
		}
		
		Iterator<String> it = strList.iterator();
		while(it.hasNext()) {
		    String obj = it.next();
		    System.out.println(obj);
		}
		
		int myKey = 1234;
		HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();
		myHashMap.put(myKey, "Value");
	}
}

