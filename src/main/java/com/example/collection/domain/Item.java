package com.example.collection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	// item, desc, amount
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String item;
	private String description;
	private int amount;
	
	public Item() {
		super();
		this.id = 0L;
		this.item = null;
		this.description = null;
		this.amount = 0;
	}
	
	public Item(String item, String description, int amount) {
		super();
		this.id = 0L;
		this.item = item;
		this.description = description;
		this.amount = amount;
	}
	
	public Item(Long id, String item, String description, int amount) {
		super();
		this.id = id;
		this.item = item;
		this.description = description;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", item=" + item + ", description=" + description + ", amount=" + amount + "]";
	}
	
	

}
