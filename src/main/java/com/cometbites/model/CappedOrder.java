package com.cometbites.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cappedOrders")
public class CappedOrder {
	
	@Id
	private String id;
	
	private String phone;
	
	private String order_status;
	
	public String getId() {
		return id;
	}

	public CappedOrder(String phone,String order_status) {
		this.phone = phone;
		this.order_status = order_status;
		// TODO Auto-generated constructor stub
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

}
