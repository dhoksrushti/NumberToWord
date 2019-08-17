package com.sdhok.java.conversions.numbertoword.processor;

import java.util.Map;

import com.sdhok.java.conversions.numbertoword.defaultwords.WordBuilder;


//Processor for processing numbers till 999
public class HundredsProcessor {
	
	private final Map<Integer, String> baseValues;
	private WordBuilder wordBuilder = null;
	
	public HundredsProcessor() {
		baseValues = null;
	}
	public HundredsProcessor(WordBuilder wordBuilder) {
		this.wordBuilder = wordBuilder;
		baseValues = this.wordBuilder.getWords();
	}
	
	public WordBuilder getWordBuilder() {
		return wordBuilder;
	}
	public String asWords(Integer value) {
	
        if (baseValues.containsKey(value)) {
            return baseValues.get(value);
        } else if(value >= 21 && value <= 99) {
            return twoDigitsNumberAsString(value);
        } else if(value >= 101 && value <= 999 ){
            return threeDigitsNumberAsString(value);
        }

        throw new IllegalArgumentException("Can't convert %d"+value);
    }

    private String twoDigitsNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        String result = new StringBuilder()
        		.append(asWords(tens))
        		.append(wordBuilder.twoDigitsNumberSeparator())
        		.append(asWords(units)).toString();
        
        return result;
    }

    private String threeDigitsNumberAsString(Integer value) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        
        String result = new StringBuilder()
        		.append(asWords(hundreds))
        		.append(' ')
        		.append(asWords(tensWithUnits)).toString();
        
        return result;
        
       
    }

	


}
