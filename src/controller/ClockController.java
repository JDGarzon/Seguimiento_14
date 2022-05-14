package controller;

import java.time.LocalTime;
import java.time.ZoneId;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class ClockController {
	
	@FXML
	Label hour;
	@FXML
	Label hour2;
	@FXML
	Label hour3;
	@FXML
	Label hour4;
	@FXML
	Label hour5;
	@FXML
	Label hour6;
	@FXML
	Label hour7;
	@FXML
	Label hour8;
	@FXML
	Label hour9;
	@FXML
	Label hour0;
	
	
	public void setMain(Main main) {
		
	}
	
	public void initialize() {
		new Thread(new Runnable() {
		    @Override public void run() {
		    	while(true) {
		    		Platform.runLater(new Runnable() {
	 		            @Override public void run() {
	 		            	ZoneId zone;
	 		            	for(int i=0;i<10;i++) {
	 							switch(i) {
	 							case 0:
	 								hour.setText(LocalTime.now()+"");
	 								break;
	 							case 1:
	 								zone=ZoneId.of("America/New_York");
	 								hour2.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 2:
	 								zone=ZoneId.of("Australia/Darwin");
	 								hour3.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 3:
	 								zone=ZoneId.of("America/Argentina/Buenos_Aires");
	 								hour4.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 4:
	 								zone=ZoneId.of("Africa/Cairo");
	 								hour5.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 5:
	 								zone=ZoneId.of("Asia/Dhaka");
	 								hour6.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 6:
	 								zone=ZoneId.of("Asia/Yerevan");
	 								hour7.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 7:
	 								zone=ZoneId.of("America/St_Johns");
	 								hour8.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 8:
	 								zone=ZoneId.of("Europe/Paris");
	 								hour9.setText(LocalTime.now(zone)+"");
	 								break;
	 							case 9:
	 								zone=ZoneId.of("America/Anchorage");
	 								hour0.setText(LocalTime.now(zone)+"");
	 								break;
	 							}
	 						}
	 		            }
	 		       });	
			    	 try {
			    		 Thread.sleep(100);
					 } catch (InterruptedException e) {
						 e.printStackTrace();
					 }
		    	}
		    	
		    }
		}).start();
	}
	
	
	
	
	
}
