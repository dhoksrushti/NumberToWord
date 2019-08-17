package com.sdhok.java.conversions.numbertoword.defaultwords;

import java.util.List;
import java.util.Map;

// Interface if we want to extend support for different other languages
public interface WordBuilder {

	public Map<Integer, String> getWords();
	
	public String getWord(Integer i) ;
	
	public char twoDigitsNumberSeparator();
	
	public  List<String> getUnits();
}