package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the binhluanseq database table.
 * 
 */
@Entity
@NamedQuery(name="Binhluanseq.findAll", query="SELECT b FROM Binhluanseq b")
public class Binhluanseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Binhluanseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}