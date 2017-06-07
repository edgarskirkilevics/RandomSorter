package com.sorter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: Random sorting object
 * Author: Edgars Kirkilevics
 * Date: 07.06.2017
 */

@Entity
@Table(name = "SORT_TBL")
public class RandomSort implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String givenString;
	
	@Column
	private String positions;
	
	@Column
	private String resultString;
	
	@Column
	private String expendedTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGivenString() {
		return givenString;
	}

	public void setGivenString(String givenString) {
		this.givenString = givenString;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getExpendedTime() {
		return expendedTime;
	}

	public void setExpendedTime(String string) {
		this.expendedTime = string;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}