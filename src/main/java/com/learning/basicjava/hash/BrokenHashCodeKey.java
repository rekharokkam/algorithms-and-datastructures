package com.learning.basicjava.hash;

public class BrokenHashCodeKey {
	private int value;
	
	public BrokenHashCodeKey (int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals (Object o) {
		if (this == o) { return true; }
		if (o instanceof BrokenHashCodeKey) {
			return ( ((BrokenHashCodeKey)o).getValue() == this.getValue() );
		}
		return false;
	}
	
	@Override
	public int hashCode () { //Broken hashCode here
		return 1;
	}
}
