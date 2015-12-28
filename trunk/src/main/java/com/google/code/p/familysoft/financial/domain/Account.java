package com.google.code.p.familysoft.financial.domain;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2496048779915384218L;
	
	private Long id;
	private String name;
	private Double value;
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
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Version
	@Column(name="OPTLOCK")
	public Integer getVersion() {
		return version;
	}
}
