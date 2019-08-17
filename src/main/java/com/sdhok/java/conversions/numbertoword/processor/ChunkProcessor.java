package com.sdhok.java.conversions.numbertoword.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sdhok.java.conversions.numbertoword.defaultwords.WordBuilder;
import com.sdhok.java.conversions.numbertoword.utils.ConversionUtils;

public class ChunkProcessor {

	private HundredsProcessor hundredsProcessor = null;
	private WordBuilder wordBuilder = null;

	public ChunkProcessor(WordBuilder wordBuilder) {
		this.wordBuilder = wordBuilder;
		hundredsProcessor = new HundredsProcessor(wordBuilder);	
	}


	// Function to process each chunk of 1000 numbers
	public String asWords(Integer bigNumber) {
		
		List<Integer> chunks = ConversionUtils.chunk(bigNumber);

		//Get the unit specific to the language 
		List<String> units = wordBuilder.getUnits().subList(0, chunks.size());

		Collections.reverse(units);
		return joinChunks(chunks.iterator(), units.iterator());
	}

	//Joining back the chunks with the required units(million/billion etc)
	private String joinChunks(Iterator<Integer> chunks, Iterator<String> units) {
		List<String> result = new ArrayList<String>();

		while (chunks.hasNext() && units.hasNext()) {
			Integer currentChunkValue = chunks.next();
			String currentUnit = units.next();

			if (currentChunkValue > 0) {
				result.add(hundredsProcessor.asWords(currentChunkValue));
				result.add(currentUnit);
			}
		}

		if (result.size() == 0) {
			return hundredsProcessor.asWords(0);
		}
		
		return ConversionUtils.joinParts(result);
	}


}
