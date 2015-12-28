package com.google.code.p.familysoft.food.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;


@Entity
public class Conflict {
	private Food source;

	@OneToOne
	public Food getSource() {
		return source;
	}
	public void setSource(Food source) {
		this.source = source;
	}
	
	@OneToOne
	public Food getOrder() {
		return order;
	}
	public void setOrder(Food order) {
		this.order = order;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private Food order;
	private String description;
	
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
