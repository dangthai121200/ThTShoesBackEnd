package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the loaiphukienseq database table.
 * 
 */
@Entity
@NamedQuery(name="Loaiphukienseq.findAll", query="SELECT l FROM Loaiphukienseq l")
public class Loaiphukienseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Loaiphukienseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}