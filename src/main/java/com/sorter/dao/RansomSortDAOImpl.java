package com.sorter.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sorter.model.RandomSort;

/**
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

@Repository
public class RansomSortDAOImpl implements RandomSortDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<RandomSort> getAllRandomSort() {

		return sessionFactory.getCurrentSession().createQuery("from RandomSort")
				.list();
	}

	
	@Override
	public void addRandomSort(RandomSort randomSort) {		
		long startTime = System.nanoTime();
		
    	//Get String of numbers and parse it to list
    	String givedString = randomSort.getGivenString();
    	List<String> givedStringNumbers = new ArrayList<String>(Arrays.asList(givedString.split(";")));
    	givedStringNumbers.add(0, "0");
    	
    	//Get string of positions and parse it to Integer array
       	String postions = randomSort.getPositions();
    	String[] pos = postions.split(";");
    	int[] array = Arrays.stream(pos).mapToInt(Integer::parseInt).toArray();
    	
    	//get values from list by positions from array
    	List<String> res = new ArrayList<String>();
    		for (int n = 0; n < pos.length; n++){
    			res.add(givedStringNumbers.get(array[n]));
    		}
    	
    	//Ascending sorting
    	Collections.sort(res);
    	
    	//Parse result to string and save it in object
    	randomSort.setResultString(String.join(";", res));
    	
		long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
       
        randomSort.setExpendedTime(estametedTimeCalc(totalTime));
		
		sessionFactory.getCurrentSession().save(randomSort);
	}
	
	/*
	 * Method process spent time and result
	 */
    public String estametedTimeCalc (long totalTime){
    	if (totalTime < 1000000) {
            return totalTime + " ns";
        }
        if (totalTime >= 1000000 && totalTime < 1000000000) {
            return totalTime/1000000 + " ms";
        }
        if (totalTime >= 1000000000 && totalTime < 60000000000L) {
            return totalTime/1000000000 + " s";
        }
        if (totalTime >= 60000000000L && totalTime < 3600000000000L) {
            return totalTime/60000000000L + " min";
        }
        return totalTime/3600000000000L + " hours";
    }

}
