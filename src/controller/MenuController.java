package controller;

import application.Main;
import javafx.fxml.FXML;

public class MenuController {
	
	Main main;
	public void setMain(Main main) {
		this.main=main;
	}
	
	@FXML
	public void clock() {
		main.openClock();
	}
	
	@FXML
	public void chronometer() {
		main.openChronometer();
	}
}
