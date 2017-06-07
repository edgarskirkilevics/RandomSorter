package com.sorter.dao;

import java.util.List;
import com.sorter.model.RandomSort;

/**
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

public interface RandomSortDAO {
			
	public List<RandomSort> getAllRandomSort();
	
	public void addRandomSort(RandomSort randomSort);
	
	public String estametedTimeCalc (long totalTime);

}
