package com.google.code.p.familysoft.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.google.code.p.familysoft.food.dao.FoodAliasDAO;
import com.google.code.p.familysoft.food.dao.FoodDAO;
import com.google.code.p.familysoft.food.domain.Food;
import com.google.code.p.familysoft.food.domain.FoodAlias;

@Controller
@RequestMapping(value="/food")
public class FoodController {
	
	private FoodDAO foodDAO;

	public FoodDAO getFoodDAO() {
		return foodDAO;
	}
	
	@Autowired 
	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}
	
	private FoodAliasDAO foodAliasDAO;
	
	public FoodAliasDAO getFoodAliasDAO() {
		return foodAliasDAO;
	}
	
	@Autowired 
	public void setFoodAliasDAO(FoodAliasDAO foodAliasDAO) {
		this.foodAliasDAO = foodAliasDAO;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(HttpServletRequest request,HttpServletResponse response,Food food, BindingResult result) {
		if (result.hasErrors()) {
			return "food/create";
		}
		foodDAO.makePersistent(food);
		String[] aliasArray = request.getParameterValues("foodAlias");
		List<FoodAlias> aliasList = new ArrayList<FoodAlias>();
		for( String alias : aliasArray)
		{
			FoodAlias foodAlias = new FoodAlias();
			foodAlias.setName(alias);
			foodAlias.setOriginal(food);
			aliasList.add(foodAlias);
			foodAliasDAO.makePersistent(foodAlias);
		}
		food.setFoodAliases(aliasList);
		
		return "redirect:/food/" + food.getId();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreate(Model model) {
		Food food = new Food();
		food.setFoodAliases(new ArrayList<FoodAlias>());
		model.addAttribute(food);
		return "food/create";
	}
}
