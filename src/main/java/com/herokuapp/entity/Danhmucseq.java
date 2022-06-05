package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the danhmucseq database table.
 * 
 */
@Entity
@NamedQuery(name="Danhmucseq.findAll", query="SELECT d FROM Danhmucseq d")
public class Danhmucseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	public Danhmucseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}