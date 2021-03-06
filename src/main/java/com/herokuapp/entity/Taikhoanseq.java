package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the taikhoanseq database table.
 * 
 */
@Entity
@Table(name="taikhoanseq")
@NamedQuery(name="Taikhoanseq.findAll", query="SELECT t FROM Taikhoanseq t")
public class Taikhoanseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	public Taikhoanseq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}