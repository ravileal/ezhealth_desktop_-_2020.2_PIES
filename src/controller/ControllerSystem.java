package controller;

import model.dao.connection.Connection;

public class ControllerSystem {
	
	private Connection connection = Connection.getInstance();
	
	public void startConnection() {
		connection.startConnection();
	}
	
	public void stopConnection() {
		connection.stopConnection();
	}
	
}
