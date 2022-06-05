package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the khuyenmaiseq database table.
 * 
 */
@Entity
@NamedQuery(name="Khuyenmaiseq.findAll", query="SELECT k FROM Khuyenmaiseq k")
public class Khuyenmaiseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Khuyenmaiseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}