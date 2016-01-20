package com.lesehome.carrot.loadingview.data;

public class Data3<VALUE1, VALUE2, VALUE3> {

	private VALUE1 value1;
	private VALUE2 value2;
	private VALUE3 value3;

	public Data3() {
		super();
	}

	public Data3(VALUE1 value1, VALUE2 value2, VALUE3 value3) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	public VALUE1 getValue1() {
		return value1;
	}

	public void setValue1(VALUE1 value1) {
		this.value1 = value1;
	}

	public VALUE2 getValue2() {
		return value2;
	}

	public void setValue2(VALUE2 value2) {
		this.value2 = value2;
	}

	public VALUE3 getValue3() {
		return value3;
	}

	public void setValue3(VALUE3 value3) {
		this.value3 = value3;
	}

}
