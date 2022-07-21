package com.herokuapp.domain.admin;

import java.util.HashSet;
import java.util.Set;

public class AddSizeAdmin {
	
	private Set<String> listSize = new HashSet<>();

	public AddSizeAdmin() {

	}

	public Set<String> getListSize() {
		return listSize;
	}

	public void setListSize(Set<String> listSize) {
		this.listSize = listSize;
	}

}
