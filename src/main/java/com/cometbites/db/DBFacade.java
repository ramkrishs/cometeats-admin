package com.cometbites.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Controller;


import com.cometbites.model.FoodJoint;
import com.cometbites.model.Item;

import com.cometbites.util.Util;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Controller
public class DBFacade {

	@Autowired
	private MongoTemplate mongoTemplate;

	
	

}
