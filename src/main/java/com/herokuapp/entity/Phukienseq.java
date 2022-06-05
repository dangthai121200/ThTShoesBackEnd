package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phukienseq database table.
 * 
 */
@Entity
@NamedQuery(name="Phukienseq.findAll", query="SELECT p FROM Phukienseq p")
public class Phukienseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Phukienseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}