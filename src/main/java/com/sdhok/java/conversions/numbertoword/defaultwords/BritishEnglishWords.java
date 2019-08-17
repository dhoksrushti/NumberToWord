package com.sdhok.java.conversions.numbertoword.defaultwords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Implemented for the British english
public class BritishEnglishWords implements WordBuilder {


	Map<Integer, String> collection =  null;

	public BritishEnglishWords() {
		collection =  new HashMap<Integer, String>();
	}

	@Override
	public Map<Integer, String> getWords() {

		this.addWord(0, "zero")
		.addWord(1, "one")
		.addWord(2, "two")
		.addWord(3, "three")
		.addWord(4, "four")
		.addWord(5, "five")
		.addWord(6, "six")
		.addWord(7, "seven")
		.addWord(8, "eight")
		.addWord(9, "nine")
		.addWord(10, "ten")
		.addWord(11, "eleven")
		.addWord(12, "twelve")
		.addWord(13, "thirteen")
		.addWord(14, "fourteen")
		.addWord(15, "fifteen")
		.addWord(16, "sixteen")
		.addWord(17, "seventeen")
		.addWord(18, "eighteen")
		.addWord(19, "nineteen")
		.addWord(20, "twenty")
		.addWord(30, "thirty")
		.addWord(40, "forty")
		.addWord(50, "fifty")
		.addWord(60, "sixty")
		.addWord(70, "seventy")
		.addWord(80, "eighty")
		.addWord(90, "ninety")
		.addWord(100, "one hundred")
		.addWord(200, "two hundred")
		.addWord(300, "three hundred")
		.addWord(400, "four hundred")
		.addWord(500, "five hundred")
		.addWord(600, "six hundred")
		.addWord(700, "seven hundred")
		.addWord(800, "eight hundred")
		.addWord(900, "nine hundred");

		return this.collection;
	}


	private BritishEnglishWords addWord(Integer key, String value){
		collection.put(key, value);
		return this;
	}

	@Override
	public  List<String> getUnits(){
		return Arrays.asList("","thousand", "million","billion");

	}

	@Override
	public char twoDigitsNumberSeparator() {
		return '-';
	}

	@Override
	public String getWord(Integer i) {
		return this.collection.get(i);
	}

}