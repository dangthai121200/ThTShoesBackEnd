package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the khachvanglaiseq database table.
 * 
 */
@Entity
@NamedQuery(name="Khachvanglaiseq.findAll", query="SELECT k FROM Khachvanglaiseq k")
public class Khachvanglaiseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Khachvanglaiseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}