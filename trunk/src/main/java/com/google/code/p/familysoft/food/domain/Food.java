package com.google.code.p.familysoft.food.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
public class Food {
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private List<FoodAlias> foodAliases;
	
	@OneToMany(mappedBy="original")
	public List<FoodAlias> getFoodAliases() {
		return foodAliases;
	}
	
	public void setFoodAliases(List<FoodAlias> foodAliases) {
		this.foodAliases = foodAliases;
	}
	
	private Long id;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private Integer version;
	@Version
	@Column(name="OPTLOCK")
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
}
