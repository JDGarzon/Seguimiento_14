package controller;

import java.time.LocalTime;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChronometerController {
	LocalTime begining;
	@FXML
	Label chronometer;
	LocalTime now;
	LocalTime stop;
	Thread pr;
	Main main;
	public void setMain(Main main) {
		this.main=main;
	}
	
	public void initialize() {
		begining=LocalTime.now();
		pr= new Thread(new Runnable() {
		    @Override public void run() {
		    	
		    	while(true) {
		    		Platform.runLater(new Runnable() {
	 		            @Override public void run() {
	 		            	LocalTime nowT=LocalTime.now();
			                nowT=nowT.minusHours(begining.getHour());
			                nowT=nowT.minusMinutes(begining.getMinute());
			                nowT=nowT.minusSeconds(begining.getSecond());
			                nowT=nowT.minusNanos(begining.getNano());
			                chronometer.setText(nowT+"");
			                now=nowT;
	 		            }
	 		       });	
			    	 try {
			    		 Thread.sleep(100);
					 } catch (InterruptedException e) {
						 e.printStackTrace();
					 }
		    	}
		    	
		    }
		});
		pr.start();
	}
	@FXML
	public void reiniciar() {
		begining=LocalTime.now();
	}
	
	public void parar() {
		try {
			stop=LocalTime.now();
			pr.suspend();
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	public void continueP() {
		try {
			LocalTime now=LocalTime.now();
			
			now=now.minusSeconds(stop.getSecond());
			now=now.minusHours(stop.getHour());
			now=now.minusMinutes(stop.getMinute());
			now=now.minusNanos(stop.getNano());
			
			begining=begining.plusSeconds(now.getSecond());
			begining=begining.plusMinutes(now.getMinute());
			begining=begining.plusHours(now.getHour());
			begining=begining.plusNanos(now.getNano());
			pr.resume();
		}catch(Exception e) {
			
		}
		
	}
	
}
