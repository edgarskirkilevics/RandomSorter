package com.sorter.service;

import java.util.List;

import com.sorter.model.RandomSort;

/**
 * Description: Interface for Random Sort service
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

public interface RandomSortService {
	
	public List<RandomSort> getAllRandomSort();
	
	public void addRandomSort(RandomSort randomSort);

}
