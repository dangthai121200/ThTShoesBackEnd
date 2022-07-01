package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the donhangseq database table.
 * 
 */
@Entity
@Table(name="donhangseq")
@NamedQuery(name="Donhangseq.findAll", query="SELECT d FROM Donhangseq d")
public class Donhangseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	public Donhangseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}