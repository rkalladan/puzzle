package com.ctm.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ctm.bean.ConferenceTrack;

public class CTMMain {
	static SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
	static int morningduration = 180;
	static int noonduration = 240;
	static int ndays = 2;
	static Map<Integer, List<ConferenceTrack>> trackMap = new HashMap<Integer, List<ConferenceTrack>>();
	static Map<Integer, List<ConferenceTrack>> shiftMap = new HashMap<Integer, List<ConferenceTrack>>();
	static Map<Integer, Integer> balMap = new HashMap<Integer, Integer>();
	//Morning shift = 180 mins
	//Aft Shift = 240
	//Get all the tracks and put it into map using their time.

	public static void main(String[] args) {
		String[] str = getTracks();
		int total =0;
		for(String st:str) {
			if(st.length()>2) {
				ConferenceTrack ct = new ConferenceTrack();
				String d = st.substring(st.length()-5,st.length());
				int duration = Integer.parseInt(d.substring(0, 2));
				total = total+duration;
				ct.setDuration(duration);
				ct.setName(st.substring(0,st.length()-6));
				//System.out.println(st.substring(0,st.length()-6));
				if(trackMap.containsKey(duration)) {
					trackMap.get(duration).add(ct);
				}else {
					List<ConferenceTrack> listCT = new ArrayList<>();
					listCT.add(ct);
					trackMap.put(duration, listCT);
				}
				
			}
		}
		System.out.println(total);
		int ms1 = 0;
		int ms2 = 0;
		int ns1 = 0;
		int ns2 = 0;
		for(Entry<Integer, List<ConferenceTrack>> entry:trackMap.entrySet()) {
			for(ConferenceTrack c: entry.getValue()) {
				List<ConferenceTrack> ctList = new ArrayList<>();
				if(ns1+ c.getDuration()<=240) {
					ns1 = ns1+ c.getDuration();
					if(shiftMap.containsKey(12)) {
						shiftMap.get(12).add(c);
					}else {
						ctList.add(c);
						shiftMap.put(12, ctList);
					}
				}else if(ns2+ c.getDuration()<=240) {
					ns2 = ns2+ c.getDuration();
					if(shiftMap.containsKey(22)) {
						shiftMap.get(22).add(c);
					}else {
						ctList.add(c);
						shiftMap.put(22, ctList);
					}
				}else if(ms1+ c.getDuration()<=180) {
					ms1 = ms1+ c.getDuration();
					if(shiftMap.containsKey(11)) {
						shiftMap.get(11).add(c);
					}else {
						ctList.add(c);
						shiftMap.put(11, ctList);
					}
				}else if(ms2+ c.getDuration()<=180) {
					ms2 = ms2+ c.getDuration();
					if(shiftMap.containsKey(21)) {
						shiftMap.get(21).add(c);
					}else {
						ctList.add(c);
						shiftMap.put(21, ctList);
					}
				}else {
					if(balMap.containsKey(c.getDuration())) {
						int count = balMap.get(c.getDuration());
						balMap.put(c.getDuration(), ++count);
					}else {
						balMap.put(c.getDuration(), 1);
					}
					
				}
			}
		}
		
		for(Entry<Integer, List<ConferenceTrack>> entry:shiftMap.entrySet()) {
			System.out.println(entry.getKey() + " ========"+ entry.getValue().size());
			for(ConferenceTrack c: entry.getValue()) {
				System.out.println(c.getName());
			}
		}
		for(Entry<Integer, Integer> entry:balMap.entrySet()) {
			System.out.println(entry.getKey() + " =="+ entry.getValue());
		}
		
	}
	
	private static String[] getTracks(){
		String str = "Writing Fast Tests Against Enterprise Rails 60min\n" + 
				"Overdoing it in Python 45min\n" + 
				"Lua for the Masses 30min\n" + 
				"Ruby Errors from Mismatched Gem Versions 45min\n" + 
				"Common Ruby Errors 45min\n" + 
				"Rails for Python Developers lightning 60min\n" + 
				"Communicating Over Distance 60min\n" + 
				"Accounting-Driven Development 45min\n" + 
				"Woah 30min\n" + 
				"Sit Down and Write 30min\n" + 
				"Pair Programming vs Noise 45min\n" + 
				"Rails Magic 60min\n" + 
				"Ruby on Rails: Why We Should Move On 60min\n" + 
				"Clojure Ate Scala (on my project) 45min\n" + 
				"Programming in the Boondocks of Seattle 30min\n" + 
				"Ruby vs. Clojure for Back-End Development 30min\n" + 
				"Ruby on Rails Legacy App Maintenance 60min\n" + 
				"A World Without HackerNews 30min\n" + 
				"User Interface CSS in Rails Apps 30min";
		String[] tracks = str.split("\n");
		return tracks;
	}

	
	//Get event add to CTM with prev & next
	//Check the date & time if it is morning or after.
	//max time is 180 mins. So before adding tell it can fit or not.
	//
}
