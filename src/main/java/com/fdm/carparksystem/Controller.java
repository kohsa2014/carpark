package com.fdm.carparksystem;

public class Controller {

	private final IView iView;
	private final IValidator iValidator;
	private final ICarParkOperator iCarParkOperator;
	private boolean exitFlag;
	private boolean initializeFlag;
	
	public Controller(IView iView, IValidator iValidator, ICarParkOperator iCarParkOperator) {
		this.iView = iView;
		this.iValidator = iValidator;
		this.iCarParkOperator = iCarParkOperator; 
		exitFlag = false;
		initializeFlag = false;
	}  
	
	public void initialize() {
		String numOfSpaces = iView.getNumOfSpaces();
		String truckSpace = iView.getOneTruckSpace();
		String carHourlyRate = iView.getCarHourlyRate();
		String truckHourlyRate = iView.getTruckHourlyRate();
		try {
			iValidator.validateInitialValues(numOfSpaces, truckSpace, carHourlyRate, truckHourlyRate);
			
			iCarParkOperator.initializeCarPark(Integer.parseInt(numOfSpaces),Integer.parseInt(truckSpace),
					Float.parseFloat(carHourlyRate),Float.parseFloat(truckHourlyRate));
			initializeFlag = true;
			
		} catch (InvalidPropertiesException e) {
			iView.display(e.getMessage());
		}
	}
	
	public void handleCommand() {
		String command = iView.getCommand();
		command = command.trim();
		if("QUIT".equals(command)) {
			exitFlag = true;
		}
		else { 
				try {
					iValidator.validateCommand(command);
					iView.display(iCarParkOperator.executeCommand(command));
				} catch (InvalidCommandException e) {
					iView.display(e.getMessage());
				}
		} 
	}

	public boolean isExit() {
		return exitFlag;
	}
	public boolean isInitialized() {
		return initializeFlag;
	}
} 
