package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the loaigiayseq database table.
 * 
 */
@Entity
@NamedQuery(name="Loaigiayseq.findAll", query="SELECT l FROM Loaigiayseq l")
public class Loaigiayseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Loaigiayseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}