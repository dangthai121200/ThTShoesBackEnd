package com.herokuapp.abstracts;

public abstract class AbstractsDomain<T> {
	public abstract void converToDomain(T object);
	public abstract T converToEntity();
}
