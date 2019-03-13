package com.hcl.rest.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector
{//jasmine
  /*static String driverManager = "org.springframework.jdbc.datasource.DriverManagerDataSource";
  static String driverClassName = "com.mysql.jdbc.Driver";
  static String url = "jdbc:mysql://ec2-52-221-247-9.ap-southeast-1.compute.amazonaws.com:3306/banker_app_schema";
  static String userName = "chatbot";
  static String password = "chatbot";*/
  

/*	static String driverManager = "org.springframework.jdbc.datasource.DriverManagerDataSource";
	  static String driverClassName = "com.mysql.jdbc.Driver";
	  static String url = "jdbc:mysql://ec2-35-171-8-176.compute-1.amazonaws.com:3306/banker_app_schema";
	  static String userName = "root";
	  static String password = "ADMIN";

*/



		static String driverManager = "org.springframework.jdbc.datasource.DriverManagerDataSource";
		  static String driverClassName = "com.mysql.jdbc.Driver";
		  static String url = "jdbc:mysql://localhost:3306/banker_app_schema";
		  static String userName = "root";
		  static String password = "root";




  public DatabaseConnector() {}
  







  public static Connection getMySqlConnection()
  {
    try
    {
      Class.forName(driverClassName);
      return DriverManager.getConnection(url, userName, password);

    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      return null;
    }
    catch (SQLException e) {
      e.printStackTrace(); }
    return null;
  }
}