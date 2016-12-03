package com.cometbites.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.cometbites.db.User;
import com.cometbites.model.FoodJoint;
import com.cometbites.model.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Component
@Path("foodjoint")
@Produces(MediaType.APPLICATION_JSON)
public class Admin {
	private static Logger log = LogManager.getLogger();
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GET
	public String getFoodJoints(@Context HttpHeaders headers) throws JsonProcessingException {
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		
		List<FoodJoint> foodJoints = mongoTemplate.findAll(FoodJoint.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonvalue = mapper.writeValueAsString(foodJoints);
		

		log.info(jsonvalue);
				
	
		return jsonvalue;
	}
	
	@GET
	@Path("{id}")
	public String getFoodJoint(@PathParam("id") String id,@Context HttpHeaders headers) throws JsonProcessingException {
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		DBObject query = new BasicDBObject();
		query.put("fjID", Integer.parseInt(id));
		
		BasicQuery q = new BasicQuery(query);
		
		FoodJoint foodJoint = mongoTemplate.findOne(q,FoodJoint.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonvalue = mapper.writeValueAsString(foodJoint);
		

		log.info(jsonvalue);
				
	
		return jsonvalue;
	}
	
	//Add Foodjoint
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String addFoodJoint(@FormParam("name") String name,
			@FormParam("open_time") String open_time,@FormParam("closed_time") String close_time,@FormParam("wait_time") String wait_time,
			@FormParam("logo") String logo,@FormParam("chef_total") String chef_total,@FormParam("chef_efficiency") String chef_efficiency,
			@FormParam("helper_total") String helper_total,@FormParam("helper_efficiency") String helper_efficiency){
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		DBObject res = new BasicDBObject();
		res.put("result", 401);
		String jsonvalue = "";
		try{
			
			FoodJoint foodjoint = new FoodJoint();
			int fjID = (int) (ms.count() + 1);
			foodjoint.setFjID(fjID);
			foodjoint.setName(name);
			foodjoint.setOpen_time(open_time);
			foodjoint.setClosed_time(close_time);
			foodjoint.setWait_time(wait_time);
			foodjoint.setLogo(logo);
			foodjoint.setChef_total(chef_total);
			foodjoint.setChef_efficiency(chef_efficiency);
			foodjoint.setHelper_total(helper_total);
			foodjoint.setHelper_efficiency(helper_efficiency);
			
			mongoTemplate.save(foodjoint);
			
			List<FoodJoint> foodJoints = mongoTemplate.findAll(FoodJoint.class);
			
			ObjectMapper mapper = new ObjectMapper();
			
			jsonvalue = mapper.writeValueAsString(foodJoints);
			
			res.put("result", 200);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		return jsonvalue;
	}
	
	
	//Update FoodJoint
	@PUT
	@Path("{id}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateFoodJoint(@PathParam("id") Integer fjID,@FormParam("name") String name,
			@FormParam("open_time") String open_time,@FormParam("closed_time") String close_time,@FormParam("wait_time") String wait_time,
			@FormParam("logo") String logo,@FormParam("chef_total") String chef_total,@FormParam("chef_efficiency") String chef_efficiency,
			@FormParam("helper_total") String helper_total,@FormParam("helper_efficiency") String helper_efficiency){
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		DBObject res = new BasicDBObject();
		res.put("result", 401);
		try{
			
			DBObject query = new BasicDBObject();
			query.put("fjID", fjID);
			BasicQuery q = new BasicQuery(query);
			
			FoodJoint foodJoint = mongoTemplate.findOne(q,FoodJoint.class);
			
			
			Update foodjoint = new Update();
			
			foodjoint.set("name",name);
			foodjoint.set("open_time",open_time);
			foodjoint.set("closed_time",close_time);
			foodjoint.set("wait_time",wait_time);
			foodjoint.set("logo",logo);
			foodjoint.set("chef_total",chef_total);
			foodjoint.set("chef_efficiency",chef_efficiency);
			foodjoint.set("helper_total",helper_total);
			foodjoint.set("helper_efficiency",helper_efficiency);
			
			mongoTemplate.updateFirst(q,foodjoint,FoodJoint.class);
			res.put("result", 200);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
			
		return res.toString();
	}
	
	//Add Menu
	@POST
	@Path("{id}/menu")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String addMenu(@PathParam("id") Integer fjID,@FormParam("name") String name,@FormParam("description") String description,
			@FormParam("image") String image,@FormParam("price") String price,@FormParam("qty") String qty){
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		DBObject res = new BasicDBObject();
		res.put("result", 400);
		Integer id = 0;
		try{
		
			DBObject query1 = new BasicDBObject();
			query1.put("fjID", fjID);
			
			FoodJoint foodjoint = mongoTemplate.findOne(new BasicQuery(query1), FoodJoint.class);
			
			if(foodjoint.getMenu() == null || foodjoint.getMenu().size() == 0){
				id = 1;
			}
			else{
				id = foodjoint.getMenu().size() + 1;
			}
			
			DBObject obj = new BasicDBObject();
			
			obj.put("id", Integer.toString(id));
			obj.put("name", name);
			obj.put("description", description);
			obj.put("image", image);
			obj.put("price", price);
			obj.put("qty", qty);
			
			DBObject query = new BasicDBObject();
			
			query.put("fjID", fjID);
			DBObject update = new BasicDBObject();
			update.put("$push", new BasicDBObject("menu", obj));
			
			WriteResult result = ms.update(query, update);
			if(result.wasAcknowledged()){
				res.put("result", 200);
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return res.toString();
	}
	
	
	//Update Menu
	@PUT
	@Path("{id}/menu/{mID}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateMenu(@PathParam("id") Integer fjID,@PathParam("mID") String id,@FormParam("name") String name,@FormParam("description") String description,
			@FormParam("image") String image,@FormParam("price") String price,@FormParam("qty") String qty){
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		DBObject res = new BasicDBObject();
		res.put("result", 400);
		try{
		
			DBObject obj = new BasicDBObject();
			obj.put("id", id);
			obj.put("name", name);
			obj.put("description", description);
			obj.put("image", image);
			obj.put("price", price);
			obj.put("qty", qty);
			
			DBObject query = new BasicDBObject();
			
			query.put("fjID", fjID);
			query.put("menu.id",id );
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject("menu", obj));
			
			WriteResult result = ms.update(query, update);
			if(result.wasAcknowledged()){
				res.put("result", 200);
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return res.toString();
	}
	
	
	//Delete Menu
	@DELETE
	@Path("{id}/menu/{mID}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMenu(@PathParam("id") Integer fjID,@PathParam("mID") String id){
		
		DBCollection ms = mongoTemplate.getCollection("foodjoints");
		DBObject res = new BasicDBObject();
		res.put("result", 400);
		try{
		
			DBObject obj = new BasicDBObject();
			
			obj.put("id", "1");
			
			
			DBObject query = new BasicDBObject();
			
			query.put("fjID", fjID);
			query.put("menu.id","1" );
			DBObject update = new BasicDBObject();
			update.put("$pull", new BasicDBObject("menu", obj));
			
			WriteResult result = ms.update(query, update);
			if(result.wasAcknowledged()){
				res.put("result", 200);
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return res.toString();
	}
	
	//Delete FoodJoint
		@DELETE
		@Path("{id}")
		@Consumes("application/x-www-form-urlencoded")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteFoodjoint(@PathParam("id") Integer fjID){
			
			DBCollection ms = mongoTemplate.getCollection("foodjoints");
			DBObject res = new BasicDBObject();
			res.put("result", 400);
			try{
			
				
				DBObject query = new BasicDBObject();
				query.put("fjID", fjID);
				WriteResult result = ms.remove(query);
				if(result.wasAcknowledged()){
					res.put("result", 200);
				}
				
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			return res.toString();
		}
	
	
	
}
