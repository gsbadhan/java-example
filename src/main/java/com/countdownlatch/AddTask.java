package com.countdownlatch;

public class AddTask implements Task {
	private Integer x;
	private Integer y;
	private Integer output;

	public AddTask(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute() {
		output = x + y;
	}
	
	public Integer getOutput(){
		return output;
	}

	@Override
	public String toString() {
		return "AddTask [x=" + x + ", y=" + y + ", output=" + output + "]";
	}
	
	

}
