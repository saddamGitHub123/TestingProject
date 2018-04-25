package com.backend.restbackend.user.model;

public class BlockDateRequest {
	
	private String SP_ID;
	private String Starting_Date;
	private String Ending_Date;
	
	
	
	
	@Override
	public String toString() {
		return "BlockDateRequest [SP_ID=" + SP_ID + ", Starting_Date=" + Starting_Date + ", Ending_Date=" + Ending_Date
				+ "]";
	}
	public String getSP_ID() {
		return SP_ID;
	}
	public void setSP_ID(String sP_ID) {
		SP_ID = sP_ID;
	}
	public String getStarting_Date() {
		return Starting_Date;
	}
	public void setStarting_Date(String starting_Date) {
		Starting_Date = starting_Date;
	}
	public String getEnding_Date() {
		return Ending_Date;
	}
	public void setEnding_Date(String ending_Date) {
		Ending_Date = ending_Date;
	}
	
	

}
