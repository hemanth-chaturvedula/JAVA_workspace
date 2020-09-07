package com.Telstra.tour;

import java.util.Arrays;

public class State_directory {
	public State[] dir;

	public State_directory(State[] dir) {
		super();
		this.dir = dir;
	}
	
	public void find_state(String s){
		boolean flag = false;
		for(State x:dir) {
			if(x.s_name==s) {
				System.out.println(x);
				flag = true;
			}
		}
		if(!flag)
			System.out.println("NA");
	}

	@Override
	public String toString() {
		return "State_directory [dir=" + Arrays.toString(dir) + "]";
	}
	
	
}
