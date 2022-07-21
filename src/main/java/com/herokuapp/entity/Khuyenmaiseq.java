package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the khuyenmaiseq database table.
 * 
 */
@Entity
@Table(name="khuyenmaiseq")
@NamedQuery(name="Khuyenmaiseq.findAll", query="SELECT k FROM Khuyenmaiseq k")
public class Khuyenmaiseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
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