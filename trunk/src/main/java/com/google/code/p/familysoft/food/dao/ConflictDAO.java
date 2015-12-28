package com.google.code.p.familysoft.food.dao;

import java.io.Serializable;
import java.util.List;

import com.google.code.p.familysoft.core.dao.BaseDAO;
import com.google.code.p.familysoft.food.domain.Conflict;

public interface ConflictDAO extends BaseDAO<Conflict, Serializable>{
	public List<Conflict> listConflictsByFoods(List<String> foodNames);
}
