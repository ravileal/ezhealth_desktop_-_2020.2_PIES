package controller;

import model.dao.connection.Connection;

public class ControllerSystem {
	
	private static Connection connection = Connection.getInstance();
	
	public void startConnection() {
		connection.startConnection();
	}
	
	public void stopConnection() {
		connection.stopConnection();
	}
	
}
