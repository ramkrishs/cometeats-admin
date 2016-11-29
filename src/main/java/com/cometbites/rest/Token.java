package com.cometbites.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;




@Repository
public class Token {
	
	
	
	
	
	
	private static Logger log = LogManager.getLogger();
	
	public void sendCode() {
		
		
		try{
			log.info("DB length ");
			
//			log.info("DB length " +ms.find().length());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	

}
