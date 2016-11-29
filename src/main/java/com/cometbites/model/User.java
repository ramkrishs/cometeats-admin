package com.cometbites.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String id;

	private String netid;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	String getNetid() {
		return netid;
	}
	
	void setNetid(String netid) {
		this.netid = netid;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", netid=" + getNetid() + "]";
	}

	

}