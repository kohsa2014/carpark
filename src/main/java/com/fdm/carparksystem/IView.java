package com.fdm.carparksystem;

public interface IView {

	public String getNumOfSpaces();

	public String getCarHourlyRate();

	public String getTruckHourlyRate();

	public String getOneTruckSpace();

	public void display(String message);

	public String getCommand();

}
