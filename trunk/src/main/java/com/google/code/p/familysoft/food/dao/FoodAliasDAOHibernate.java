package com.google.code.p.familysoft.food.dao;


import org.springframework.stereotype.Repository;

import com.google.code.p.familysoft.core.dao.BaseDAOHibernate;
import com.google.code.p.familysoft.food.domain.FoodAlias;


@Repository("foodAliasDAO") 
public class FoodAliasDAOHibernate extends BaseDAOHibernate<FoodAlias, Long> implements
		FoodAliasDAO {
	
}
