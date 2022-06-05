package com.herokuapp.abstracts;

public abstract class Convert<T> {
	public abstract void converToDomain(T object);
	public abstract T converToEntity();
}
