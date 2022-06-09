package com.yedam.java.ch1501;

public class Box<T, V, K> {

	T t;
	V v;
	K k;

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setV(V v) {
		this.v = v;
	}

	public V getV() {
		return v;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

}
