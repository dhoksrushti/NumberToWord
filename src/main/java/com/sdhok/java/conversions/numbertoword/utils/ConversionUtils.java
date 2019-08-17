package com.sdhok.java.conversions.numbertoword.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ConversionUtils {


	private static final Integer SPLIT_UNIT = 1000;
	
	//Creating chunks
	public static  List<Integer> chunk(Integer value) {
		Deque<Integer> result = new ArrayDeque<Integer>();

		while (value > 0) {
			result.addFirst(value % SPLIT_UNIT);
			value /= SPLIT_UNIT;
		}

		return new ArrayList<Integer>(result);
	}

	
	//Creating output String from the generated list 
	public static String joinParts(List<String> result) {
		
		StringBuilder s = new StringBuilder();
		result.forEach(e -> s.append(e +" "));

		return s.toString();
	}
	
}
