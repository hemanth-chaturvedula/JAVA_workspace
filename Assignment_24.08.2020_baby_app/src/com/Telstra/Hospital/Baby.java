package com.Telstra.Hospital;

import java.util.Date;
import java.lang.String;

public class Baby {
	
	//weight in kgs
	//height in cms
	
	public int ID;
	
	private int Weight;
	private int Height;
	private Date Date_born;
	private String Attending_Doc;
	private boolean Comp_check;
	private boolean Doc_check;
	private boolean Baby_health;
	private String Comments;	
	
	public static int Low_w_th;
	public static int Low_h_th;
	public static int High_w_th;
	public static int High_h_th;
	
	static {
		Low_w_th = 2.26;
		Low_h_th = 48.26;
		High_w_th = 3.62;
		High_h_th = 53.34;
	}

	private Baby(int iD, int weight, int height, Date date_born, String attending_Doc) {
		super();
		ID = iD;
		Weight = weight;
		Height = height;
		Date_born = date_born;
		Attending_Doc = attending_Doc;
		Comp_check = false;
		Doc_check = false;
		Baby_health = false;
	}
	
	public void comp_check() {
		if(this.Weight > Low_w_th && this.Weight < High_w_th && this.Height > Low_h_th && this.Height < High_w_th) {
			if(this.Doc_check == false)
				this.Baby_health = true;
			else
				this.Baby_health = this.Baby_health && true;
		}
		else
			this.Baby_health = false;
		this.Comp_check = true;
	}
	
	
}
