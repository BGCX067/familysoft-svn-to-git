package com.google.code.p.familysoft.food.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class FoodAlias {
	
	private String name;

	private Food original;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	public Food getOriginal() {
		return original;
	}

	public void setOriginal(Food original) {
		this.original = original;
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
