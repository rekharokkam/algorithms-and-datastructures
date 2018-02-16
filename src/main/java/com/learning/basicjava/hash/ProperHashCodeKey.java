package com.learning.basicjava.hash;

public class ProperHashCodeKey {
	
	private int value;
	
	public ProperHashCodeKey (int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public int hashCode () {
		return value;
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {return true;}
		if (o instanceof ProperHashCodeKey) {
			return ( ((ProperHashCodeKey)o).getValue() == this.getValue());
		}
		return false;
	}
}
