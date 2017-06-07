package com.sorter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorter.dao.RandomSortDAO;
import com.sorter.model.RandomSort;

/**
 * Description: Random Sort service
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

@Service
@Transactional
public class RandomSortServiceImpl implements RandomSortService {

	@Autowired
	private RandomSortDAO randomSortDAO;

	@Override
	@Transactional
	public List<RandomSort> getAllRandomSort() {
		return randomSortDAO.getAllRandomSort();
	}

	@Override
	public void addRandomSort(RandomSort randomSort) {
		randomSortDAO.addRandomSort(randomSort);
		
	}

}
