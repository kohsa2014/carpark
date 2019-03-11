package com.fdm.carparksystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class RunCarParkSystem 
{
    public static void main( String[] args )
    {
        Console console = new Console();
    	Scanner keyboard = new Scanner(System.in);
    	Properties prop = new Properties();
    	InputValidator validator = new InputValidator();
    	CarParkFactory factory = new CarParkFactory();
    	CarParkOperator operator = new CarParkOperator(factory);
    	
    	try(FileInputStream input = new FileInputStream("src/resources/carpark.properties")) {
				
				prop.load(input);
				CarParkView view = new CarParkView(prop, keyboard, console);
				Controller controller = new Controller(view, validator, operator);

				while(!controller.isInitialized()) {
						controller.initialize();
				}
				while(!controller.isExit()) {
						controller.handleCommand();
				}
				
    		} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	
    	keyboard.close();
    }
}
