package com.google.code.p.familysoft.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.p.familysoft.food.dao.ConflictDAO;
import com.google.code.p.familysoft.food.dao.FoodAliasDAO;
import com.google.code.p.familysoft.food.dao.FoodDAO;
import com.google.code.p.familysoft.food.domain.Conflict;
import com.google.code.p.familysoft.food.domain.Food;
import com.google.code.p.familysoft.food.domain.FoodAlias;


@Controller
@RequestMapping(value="/conflict")
public class ConflictController {
	@RequestMapping(method=RequestMethod.POST)
	public String create(HttpServletRequest request,HttpServletResponse response,Conflict conflict, BindingResult result) {
		if (result.hasErrors()) {
//			return "conflict/create";
		}
		String sourceFoodName = request.getParameter("source");
		String orderFoodName = request.getParameter("order");
		Food sourceFood = getFoodByName(sourceFoodName);
		Food orderFood = getFoodByName(orderFoodName);
		conflict.setSource(sourceFood);
		conflict.setOrder(orderFood);
		confictDAO.makePersistent(conflict);
		return "redirect:/conflict/" + conflict.getId();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreate(Model model) {
		Conflict confict = new Conflict();
		model.addAttribute(confict);
		return "conflict/create";
	}
	
	@RequestMapping(value="check", method=RequestMethod.GET)
	public String checkForm(Model model)
	{
		return "conflict/check";
	}

	@RequestMapping(value="check", method=RequestMethod.POST)
	public String checkResult(HttpServletRequest request,HttpServletResponse response)
	{
		
		return "/conflict/check";
	}
	
	private Food getFoodByName(String foodName)
	{
		Food food = new Food();
		food.setName(foodName);
		List<Food> foodList = foodDAO.findByExample(food);
		return foodList.size()==0 ? getFoodByFoodAliasName(foodName) : foodList.get(0);
	}
	
	private Food getFoodByFoodAliasName( String aliasName )
	{
		FoodAlias foodAliasExample = new FoodAlias();
		foodAliasExample.setName(aliasName);
		List<FoodAlias> aliasList = foodAliasDAO.findByExample(foodAliasExample);
		if(aliasList.size() == 0)
		{
			Food result = new Food();
			result.setName(aliasName);
			foodDAO.makePersistent(result);
			return result;
		} else {
			return aliasList.get(0).getOriginal();
		}
	}
	private FoodAliasDAO foodAliasDAO;
	
	public FoodAliasDAO getFoodAliasDAO() {
		return foodAliasDAO;
	}
	@Autowired
	public void setFoodAliasDAO(FoodAliasDAO foodAliasDAO) {
		this.foodAliasDAO = foodAliasDAO;
	}

	private FoodDAO foodDAO;
	
	public FoodDAO getFoodDAO() {
		return foodDAO;
	}
	@Autowired
	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}
	private ConflictDAO confictDAO;

	public ConflictDAO getConfictDAO() {
		return confictDAO;
	}
	
	@Autowired
	public void setConfictDAO(ConflictDAO confictDAO) {
		this.confictDAO = confictDAO;
	}
}
