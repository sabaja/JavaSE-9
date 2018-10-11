package com.javaTimeAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.ZoneId;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;

class AllZoneIDAvaible {

	public static void main(String[] args) {
		Set<String>allZoneID = ZoneId.getAvailableZoneIds();
		TreeSet<String> ts = new TreeSet<>(allZoneID);//Set ordinato 
		for(String ids : ts){
			System.out.println(ids);
		}
		zoneIdSavingFile();
	}
	
	private static void zoneIdSavingFile(){
		try {
			FileOutputStream fos = new FileOutputStream(new File("IDtimeZone.txt"));
			PrintStream ps = new PrintStream(fos);
			String[] zoneId = TimeZone.getAvailableIDs(); 
			for(String i : zoneId){
				ps.println(i);
			}
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
