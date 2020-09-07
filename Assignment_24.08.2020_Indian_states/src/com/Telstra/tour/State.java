package com.Telstra.tour;

import java.util.Arrays;

public class State {
	public String s_name;
	public String[] suggestions= new String[3];
	
	
	
	public State(String s_name, String[] suggestions) {
		super();
		this.s_name = s_name;
		this.suggestions = suggestions;
	}



	@Override
	public String toString() {
		return "State [s_name=" + s_name + ", suggestions=" + Arrays.toString(suggestions) + "]";
	}
	
	
}

