package com.sdhok.java.conversions.numbertoword.service;

import java.util.Optional;

import com.sdhok.java.conversions.numbertoword.defaultwords.BritishEnglishWords;
import com.sdhok.java.conversions.numbertoword.defaultwords.WordBuilder;
import com.sdhok.java.conversions.numbertoword.processor.ChunkProcessor;

//This Class performs the basic validation and makes call to respective processors depending on input 
public class NumberProcessor {

	private ChunkProcessor chunkProcessor = null;
	private WordBuilder wordBuilder = null;
	
	
	public NumberProcessor(String language) {
		
		if(language == null) {  //default language
			wordBuilder = new BritishEnglishWords();
		}else if(language.equalsIgnoreCase("en-gb"))  // British-English
		{
			wordBuilder = new BritishEnglishWords();
		}else {
			//Invalid Language provided  Here, we can add support for new language
		}
		
	}
	
	//Method which need to call to convert the number to word
	public String process(Integer bigNumber) {
		if(!validateInput(bigNumber)) {return null;}
		
		Optional.ofNullable(wordBuilder).orElseThrow(() -> new RuntimeException("Language is not correct or support is yet to implement.."));
		
		System.out.println("Output String ----");
		// return if the number is available in default list, effective for small number
		if(wordBuilder.getWords().containsKey(bigNumber)) 
			return wordBuilder.getWords().get(bigNumber);
		
		
		chunkProcessor = new ChunkProcessor(wordBuilder);
		
		return chunkProcessor.asWords(bigNumber);
	}

	//Input Validation
	private boolean validateInput(Integer i) {

		if(i < 0) {
			System.out.println("can't convert negative numbers for value %d"+i);
			return false;
		}else if(i > 999999999) {
			System.out.println("can't convert  numbers greter than 999999999 for value %d"+i);
			return false;
		}
		return true;
	}
}

