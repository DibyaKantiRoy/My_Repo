package com.rest.model;

public class DataSource {
	
	private String dbURL;
	private String dbUserName;
	private String dbPassword;
	private String dbName;
	private String dbPort;
	private String dbDriverClass;

	public String getDbURL() {
		return dbURL;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbDriverClass() {
		return dbDriverClass;
	}
	public void setDbDriverClass(String dbDriverClass) {
		this.dbDriverClass = dbDriverClass;
	}
	
}
