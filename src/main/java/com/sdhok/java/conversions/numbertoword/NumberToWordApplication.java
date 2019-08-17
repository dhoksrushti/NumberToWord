package com.sdhok.java.conversions.numbertoword;

import java.util.Scanner;

import com.sdhok.java.conversions.numbertoword.service.NumberProcessor;


public class NumberToWordApplication 
{
	public static void main( String[] args )
	{
		NumberProcessor n = new NumberProcessor("en-gb");
		Scanner sc = new Scanner(System.in); 

		//int age = sc.nextInt(); 

		while (sc.hasNextInt())
			System.out.println(n.process(sc.nextInt()) ); 


		

	}
}
