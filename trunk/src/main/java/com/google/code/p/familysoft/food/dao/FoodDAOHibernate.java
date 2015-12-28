package com.google.code.p.familysoft.food.dao;


import org.springframework.stereotype.Repository;

import com.google.code.p.familysoft.core.dao.BaseDAOHibernate;
import com.google.code.p.familysoft.food.domain.Food;


@Repository("foodDAO") 
public class FoodDAOHibernate extends BaseDAOHibernate<Food, Long> implements
		FoodDAO {
	
}
