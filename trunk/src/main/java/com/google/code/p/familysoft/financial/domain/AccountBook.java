package com.google.code.p.familysoft.financial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class AccountBook {
	private static final long serialVersionUID = -2496048779915384218L;
	
	private Long id;
	private String name;
	private String type;
	
	private Integer version;
	
	@Id 
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	
	@Version
	@Column(name="OPTLOCK")
	public Integer getVersion() {
		return version;
	}
}
