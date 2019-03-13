package com.hcl.rest.service;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hcl.rest.Database.DatabaseConnector;
import java.util.Scanner;
public class test  {
	
	



    public static void main(String args[]) {
           String word = "Hello World";

      

        System.out.println(reverse(word));

      
    }   
	        
	        public static String reverse(String source){

	            if(source == null || source.isEmpty()){

	                return source;

	            }       

	            String reverse = "";
int count=0;
	            for(int i = source.length() -1; i>=0; i--){
	            	
             int j=source.charAt(i);
	             
	                String next= String.valueOf((char)(j+count));
System.out.println("=------------=  "+next);
reverse=reverse+next;
count++;
	            }
	            
	          

	            return reverse;

	        }
	}

	

		