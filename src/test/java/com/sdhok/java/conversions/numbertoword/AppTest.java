package com.sdhok.java.conversions.numbertoword;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
   
	
    public AppTest( String testName )
    {
        super( testName );
      /* 
        NumberProcessor n = new NumberProcessor("en-gb");
        n.process(42009999);
       
        WordBuilder wb = new BritishEnglishWords();
        ChunkProcessor chunkProcessor = new ChunkProcessor(wb);
        
        chunkProcessor.asWords(42009999);
      //  assertEquals("forty-two million nine thousand nine hundred ninety-nine",  chunkProcessor.asWords(42009999));
        
     */
    }

  
   
    public static Test suite()
    {
        return new TestSuite( AppTest.class);
    }

   
    public void testApp()
    {
        assertTrue( true );
    }
}
