package com.google.code.p.familysoft.food.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.code.p.familysoft.core.dao.BaseDAOHibernate;
import com.google.code.p.familysoft.food.domain.Conflict;

@Repository("confictDAO")
public class ConflictDAOHibernate extends BaseDAOHibernate<Conflict, Serializable> implements ConflictDAO{

	@Override
	public List<Conflict> listConflictsByFoods(List<String> foodNames) {
		// TODO Auto-generated method stub
		return null;
	}

}
