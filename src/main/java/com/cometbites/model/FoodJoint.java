package com.cometbites.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foodjoints")
public class FoodJoint {
	
	@Id
	private String id;
	
	private String name;
	

	private Integer fjID;
	
	private String logo;
	
	private String open_time;
	
	private String closed_time;
	
	private String wait_time;
	
	private String chef_total;
	
	private String chef_efficiency;
	
	private String helper_total;
	
	private String helper_efficiency;
	
	private String delay_time;
	
	private List<Item> menu;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getFjID() {
		return fjID;
	}

	public void setFjID(Integer fjID) {
		this.fjID = fjID;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getOpen_time() {
		return open_time;
	}

	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	public String getClosed_time() {
		return closed_time;
	}

	public void setClosed_time(String close_time) {
		this.closed_time = close_time;
	}

	public String getWait_time() {
		return wait_time;
	}

	public void setWait_time(String wait_time) {
		this.wait_time = wait_time;
	}

	public String getChef_total() {
		return chef_total;
	}

	public void setChef_total(String chef_total) {
		this.chef_total = chef_total;
	}

	public String getChef_efficiency() {
		return chef_efficiency;
	}

	public void setChef_efficiency(String chef_efficiency) {
		this.chef_efficiency = chef_efficiency;
	}

	public String getHelper_total() {
		return helper_total;
	}

	public void setHelper_total(String helper_total) {
		this.helper_total = helper_total;
	}

	public String getHelper_efficiency() {
		return helper_efficiency;
	}

	public void setHelper_efficiency(String helper_efficiency) {
		this.helper_efficiency = helper_efficiency;
	}

	public String getDelay_time() {
		return delay_time;
	}

	public void setDelay_time(String delay_time) {
		this.delay_time = delay_time;
	}

	public List<Item> getMenu() {
		return menu;
	}

	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

}
