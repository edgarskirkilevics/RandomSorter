package com.sorter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorter.model.RandomSort;

/**
 * Description: Error processing service
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

@Service
@Transactional
public class ErrorCheckingService {
	
	public String getError(RandomSort randomSort){		
		
		//Regex that allows only numbers and ; as separator in String. 
		String regexForGivenString = "((?<!^;)\\d+(;(?!$)|$))+";
		String regexForPositions = "((?<!^;)[1-9]+(;(?!$)|$))+";
		
		//Checking of values and return results
		if(!randomSort.getGivenString().matches(regexForGivenString)){
			return "error1";
		
		} else if(!randomSort.getPositions().matches(regexForPositions)){
			return "error2";
		
		}else{
			/*
			 * Checking max value in possition array and size-1 in given String list,
			 * checking is needed for deny situations when number in position string are 
			 * bigger than max list size
			 */
			String givedString = randomSort.getGivenString();
	    	List<String> givedStringNumbers = new ArrayList<String>(Arrays.asList(givedString.split(";")));
	    	givedStringNumbers.add(0, "0");
	    	
	    	//Get string of positions and parse it to array
	       	String postions = randomSort.getPositions();
	    	String[] ary = postions.split(";");
	    	int[] array = Arrays.stream(ary).mapToInt(Integer::parseInt).toArray();
	    	
	    	int max = Integer.MIN_VALUE, maxIndex = 0;
	    	for (int i = 0; i < array.length; i++) {
	    	     if ((array[i]) > max) {
	    	         max = (array[i]);
	    	         maxIndex = i;
	    	     }
	    	}
	    	int itemCount = givedStringNumbers.size()-1;

	    	if(itemCount < max){
				return "error3";
			}else{
				return "noErrors";
			}	
		}
	}
}
