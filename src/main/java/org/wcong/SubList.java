package org.wcong;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;


public class SubList {
	
	
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		for(int i = 0;i<=10000;i++){
			input.add(String.valueOf(i));
		}
		
		List<List<String>> out = split(input);
		System.out.println(out.size());
		
	}
	
	
	public  static List<List<String>> split(List<String> input){
		List<List<String>> result = new ArrayList<List<String>>();
		while(!input.isEmpty()){
			if(input.size()<1000){
				result.add(new ArrayList(input));
				input.clear();
			}else{
				List<String> tmp  = new ArrayList(input.subList(0, 999));
				result.add(tmp);
				input = input.subList(999, input.size());
			}
		}
		
		
		return result;
		
	}
	
	private static List<List<String>> split1(List<String> input){
		List<List<String>> result = new ArrayList();
		if(input.size()<=999){
			result.add(input);
			return result;
		}else{
			while(CollectionUtils.isNotEmpty(input)){
				if(input.size()>999){
					List<String> sub =  new ArrayList(input.subList(0, 998));
					result.add(sub);
					input = input.subList(998,input.size());
				}else{
					result.add(new ArrayList(input));
					input.clear();
				}
			}
		}
		return result;
	}

}
