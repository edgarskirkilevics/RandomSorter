package com.sorter.controller;

import java.io.IOException;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sorter.model.RandomSort;
import com.sorter.service.ErrorCheckingService;
import com.sorter.service.RandomSortService;

/**
 * Description: Controller for process requests
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

@Controller
public class RandomSortController {

	private static final Logger logger = Logger
			.getLogger(RandomSortController.class);

	public RandomSortController() {
		System.out.println("RandomSortController()");
	}

	@Autowired
	private RandomSortService randomSortService;
	
	@Autowired
	private ErrorCheckingService errorService;
	
	
    @RequestMapping("/")
    public String home() {
        return "home";
    }
	
	@RequestMapping(value = "/randomSortResultList", method = RequestMethod.GET)
	public ModelAndView listAllSortResults(ModelAndView model) throws IOException {
		List<RandomSort> randomSortList = randomSortService.getAllRandomSort();
		model.addObject("randomSortList", randomSortList);
		model.setViewName("RandomSortResultList");
		return model;
	}

	@RequestMapping(value = "/newRandomSort", method = RequestMethod.GET)
	public ModelAndView newRandomSort(ModelAndView model) {
		RandomSort randomSort = new RandomSort();
		model.addObject("randomSort", randomSort);
		model.setViewName("RandomSortForm");
		return model;
	}

	@RequestMapping(value = "/saveRandomSort", method = RequestMethod.POST)
	public ModelAndView saveRandomSort(@ModelAttribute RandomSort randomSort, ModelAndView model) {
		String error = errorService.getError(randomSort);		
		if(error.equals("error1")){
			model.addObject("error1", "Wrong string of numbers! Check it!");
			model.setViewName("RandomSortForm");
			return model;
		} else if(error.equals("error2")){
			model.addObject("error2", "Wrong string of numbers! Check it!");
			model.setViewName("RandomSortForm");
			return model;
		} else if(error.equals("error3")){
			model.addObject("error3", "Position has larger number of elements than elemenets in Random Number String");
			model.setViewName("RandomSortForm");
			return model;	
		}else {
			randomSortService.addRandomSort(randomSort);
			return new ModelAndView("redirect:/randomSortResultList");
		}
			
	}

}