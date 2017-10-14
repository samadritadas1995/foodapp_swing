package com.stackroute.foodies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="fooddb")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String urlPic;
	private int cost_for_two;
//	public Restaurant() {
//		
//	}
//	@Autowired
//	public Restaurant(String id, String name, String urlPic, int cost_for_two) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.urlPic = urlPic;
//		this.cost_for_two = cost_for_two;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlPic() {
		return urlPic;
	}
	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}
	public int getCost_for_two() {
		return cost_for_two;
	}
	public void setCost_for_two(int cost_for_two) {
		this.cost_for_two = cost_for_two;
	}

}
