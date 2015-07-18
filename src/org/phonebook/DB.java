package org.phonebook;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public void Start() throws SQLException{
		try{
			connection = null;
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:BASE.s3db");
		}catch(ClassNotFoundException e){}
	}
	
	//if the table does not exists
	//then create it
	public void CreateTable() throws SQLException{
		statement = connection.createStatement();
		
		statement.execute("CREATE TABLE if not exists 'contacts' (" +
					"'id' INTEGER PRIMARY KEY AUTOINCREMENT, "+
					"'name' text, " +
					"'phone' text)"
				);
	}
	
	public void Write(String name, String phone) throws SQLException{
		statement.execute("INSERT INTO contacts(name, phone) VALUES (" +
					"'" + name + "'" + ", " +
					"'" + phone + "'" +")");

	}
	
	//get the full list
	public String ReadFull() throws SQLException{
		StringBuilder sb = new StringBuilder();
		resultSet = statement.executeQuery("SELECT * FROM contacts");
		while(resultSet.next()){
			sb.append(resultSet.getString("name")).append(" ").append(resultSet.getString("phone")).append("\n");
		}
		return sb.toString();
	}
	
	public String Search(String text) throws SQLException{
		StringBuilder sb = new StringBuilder();
		resultSet = statement.executeQuery("SELECT * FROM contacts WHERE name LIKE '" + text + "%'");
		while(resultSet.next()){
			sb.append(resultSet.getString("name")).append(" ").append(resultSet.getString("phone")).append("\n");
		}
		return sb.toString();
	}
	
	//close all connection
	public void Close() throws SQLException{
		try{
			statement.close();
			resultSet.close();
			connection.close();
		}catch(NullPointerException e){}
	}
}
